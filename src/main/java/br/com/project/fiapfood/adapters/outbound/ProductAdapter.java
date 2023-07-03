package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import br.com.project.fiapfood.adapters.inbound.mapper.ProductMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ProductRepository;
import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.out.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public Product update(Product product) throws ChangeSetPersister.NotFoundException {
        ProductEntity productOld = productRepository.findById(product.getId()).
                orElseThrow(ChangeSetPersister.NotFoundException::new);
        productMapper.updateProductEntityFromProduct(product, productOld);
        return productMapper.productEntityToProduct(productRepository.save(productOld));

    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productMapper.productEntitiesToProducts(productRepository.findAllByCategory(category));
    }
}
