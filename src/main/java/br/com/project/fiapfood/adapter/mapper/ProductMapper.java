package br.com.project.fiapfood.adapter.mapper;

import br.com.project.fiapfood.external.infrastructure.entity.ProductEntity;
import br.com.project.fiapfood.adapter.dto.request.ProductRequest;
import br.com.project.fiapfood.adapter.dto.response.ProductResponse;
import br.com.project.fiapfood.domain.model.Product;
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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Product updateProductFromProduct(Product product, @MappingTarget Product productOld);


}
