package br.com.project.fiapfood.adapter.controller;

import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.domain.enums.Category;
import br.com.project.fiapfood.adapter.dto.request.ProductRequest;
import br.com.project.fiapfood.adapter.dto.response.ProductResponse;
import br.com.project.fiapfood.adapter.mapper.ProductMapper;
import br.com.project.fiapfood.domain.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    private final ProductUseCase productUseCase;


    public ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest){
        var product = productMapper.productRequestToProduct(productRequest);
        return ResponseEntity.ok(productMapper.productToProductResponse(productUseCase.createProduct(product)));

    }


    public ResponseEntity<Void> deleteProduct( UUID id){
        productUseCase.delete(id);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<ProductResponse> updateProduct(UUID id, ProductRequest productRequest) throws ObjectNotFoundException {

        var product = productMapper.productRequestToProduct(productRequest);
        product.setId(id);
        var updateProduct = productUseCase.update(product);

        return ResponseEntity.ok(productMapper.productToProductResponse(updateProduct));
    }


    public ResponseEntity<List<ProductResponse>> findProductsByCategory(Category category)  {
        return ResponseEntity.ok(productMapper.productsToProductsResponse(productUseCase.findByCategory(category)));
    }

    public ResponseEntity<List<ProductResponse>> findProductsByCategoryAndActive( Category category)  {
        return ResponseEntity.ok(productMapper.productsToProductsResponse(productUseCase.findByCategoryAndStatusActive(category)));
    }

}
