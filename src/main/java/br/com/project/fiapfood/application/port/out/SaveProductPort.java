package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Product;

public interface SaveProductPort {
    Product save(Product product);
}
