package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import br.com.project.fiapfood.adapters.inbound.mapper.ProductMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ProductRepository;
import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.out.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

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
    public Product update(Product product) {
        Optional<ProductEntity> productOld = productRepository.findById(product.getId());
        if (productOld.isEmpty()) {
            return null;
        }
        productMapper.updateProductEntityFromProduct(product, productOld.get());
        return productMapper.productEntityToProduct(productRepository.save(productOld.get()));

    }
}
