package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.in.ProductServicePort;
import br.com.project.fiapfood.application.port.out.ProductPort;
import org.springframework.stereotype.Component;

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
}
