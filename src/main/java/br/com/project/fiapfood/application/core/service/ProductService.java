package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.in.ProductServicePort;
import br.com.project.fiapfood.application.port.out.ProductPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductService implements ProductServicePort {

    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productPort.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        this.productPort.delete(id);
    }

    @Override
    public Product updateProduct(Product product){
        return this.productPort.update(product);
    }

    @Override
    public Product findById(UUID id) {
        return this.productPort.findById(id);
    }

    @Override
    public List<Product> findProductsByCategory(Category category) {
        return this.productPort.findByCategory(category);
    }

    @Override
    public List<Product> findByCategoryAndStatusActive(Category category) {
        return this.productPort.findByCategoryAndStatusActive(category);
    }

    public Product findByIdAndStatusActive(UUID id ) {
        return this.productPort.findByIdAndStatusActive(id);
    }
}
