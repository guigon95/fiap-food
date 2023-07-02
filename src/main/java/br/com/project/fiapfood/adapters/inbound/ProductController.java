package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ProductMapper;
import br.com.project.fiapfood.adapters.inbound.request.ProductRequest;
import br.com.project.fiapfood.adapters.inbound.response.ProductResponse;
import br.com.project.fiapfood.application.port.in.SaveProductServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    private final SaveProductServicePort saveProductServicePort;

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

        var product = productMapper.ProductRequestToProduct(productRequest);
        return productMapper.ProductToProductResponse(saveProductServicePort.saveProduct(product));

    }

}
