package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.Product;

import java.util.UUID;

public interface ProductServicePort {
    Product saveProduct(Product product);
    void deleteProduct(UUID id);

}
