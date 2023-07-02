package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import br.com.project.fiapfood.adapters.inbound.request.ProductRequest;
import br.com.project.fiapfood.adapters.inbound.response.ProductResponse;
import br.com.project.fiapfood.application.core.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product ProductEntityToProduct(ProductEntity ProductEntity);

    ProductEntity ProductToProductEntity(Product product);

    Product ProductRequestToProduct(ProductRequest productRequest);

    ProductResponse ProductToProductResponse(Product product);



}
