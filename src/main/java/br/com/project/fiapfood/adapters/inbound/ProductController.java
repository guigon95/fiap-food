package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.adapters.inbound.mapper.ProductMapper;
import br.com.project.fiapfood.adapters.inbound.request.ProductRequest;
import br.com.project.fiapfood.adapters.inbound.response.ProductResponse;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.application.port.in.ProductServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Access to product management")
public class ProductController {

    private final ProductMapper productMapper;

    private final ProductServicePort productServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public ProductResponse saveProduct(@RequestBody @Valid ProductRequest productRequest){

        var product = productMapper.productRequestToProduct(productRequest);
        return productMapper.productToProductResponse(productServicePort.saveProduct(product));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product updated"),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public void deleteProduct(@PathVariable @Valid @org.hibernate.validator.constraints.UUID UUID id){
        productServicePort.deleteProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public ProductResponse updateProduct(@PathVariable @Valid @org.hibernate.validator.constraints.UUID UUID id,
                                         @RequestBody @Valid ProductRequest productRequest) throws ObjectNotFoundException {

        var product = productMapper.productRequestToProduct(productRequest);
        product.setId(id);
        var updateProduct = productServicePort.updateProduct(product);
        if (updateProduct == null){
            throw new ObjectNotFoundException("Product not found");
        }
        return productMapper.productToProductResponse(updateProduct);

    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Search all products by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product get",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public List<ProductResponse> findProductsByCategory(@PathVariable @Valid Category category)  {
        return productMapper.productsToProductsResponse(productServicePort.findProductsByCategory(category));
    }

    @GetMapping("/category/{category}/status/active")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Search all products by category and status ACTIVE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product get",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public List<ProductResponse> findProductsByCategoryAndActive(@PathVariable @Valid Category category)  {
        return productMapper.productsToProductsResponse(productServicePort.findByCategoryAndStatusActive(category));
    }

}
