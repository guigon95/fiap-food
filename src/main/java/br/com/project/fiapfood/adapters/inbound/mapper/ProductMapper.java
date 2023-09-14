package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import br.com.project.fiapfood.adapters.inbound.request.ProductRequest;
import br.com.project.fiapfood.adapters.inbound.response.ProductResponse;
import br.com.project.fiapfood.application.core.domain.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productEntityToProduct(ProductEntity productEntity);

    ProductEntity productToProductEntity(Product product);

    Product productRequestToProduct(ProductRequest productRequest);

    ProductResponse productToProductResponse(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateProductEntityFromProduct(Product product, @MappingTarget ProductEntity productEntity);

    List<Product> productEntitiesToProducts(List<ProductEntity> productEntities);
    List<ProductResponse> productsToProductsResponse(List<Product> products);


}
