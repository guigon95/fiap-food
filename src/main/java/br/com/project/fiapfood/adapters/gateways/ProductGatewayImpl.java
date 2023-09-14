package br.com.project.fiapfood.adapters.gateways;

import br.com.project.fiapfood.external.gateway.ProductGateway;
import br.com.project.fiapfood.infrastructure.entity.ProductEntity;
import br.com.project.fiapfood.domain.enums.Category;
import br.com.project.fiapfood.domain.enums.Status;
import br.com.project.fiapfood.adapters.mapper.ProductMapper;
import br.com.project.fiapfood.infrastructure.repository.JPA.ProductRepository;
import br.com.project.fiapfood.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Repository
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    @Override
    public Product save(Product product) {
        var productEntity = productMapper.productToProductEntity(product);
        return productMapper.productEntityToProduct(productRepository.save(productEntity));
    }

    @Override
    public void delete(UUID id) {
        productRepository.updateStatusById(Status.DESACTIVE, id);
    }

    @Override
    public Product update(Product product, Product productOld) {
        ProductEntity productEntity = productMapper.productToProductEntity( productMapper.
                updateProductFromProduct(product, productOld));
        return productMapper.productEntityToProduct(
                productRepository.save(productEntity));

    }

    @Override
    public List<Product> findAllByCategory(Category category) {
        return productMapper.productEntitiesToProducts(productRepository.findAllByCategory(category));
    }

    @Override
    public Product findById(UUID id) {
        return productMapper.productEntityToProduct(productRepository.findById(id).
                orElse(null));
    }

    @Override
    public List<Product> findAllByCategoryAndStatus(Category category, Status status) {
        return productMapper.productEntitiesToProducts(productRepository.findAllByCategoryAndStatus(category, status));
    }

    @Override
    public Product findByIdAndStatus(UUID id, Status status) {
        return productMapper.productEntityToProduct(productRepository.findByIdAndStatus(id, status)
                .orElse(null));    }
}
