package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.Product;

public interface SaveProductServicePort {
    public Product saveProduct(Product product);
}
