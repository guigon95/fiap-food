package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.application.core.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductPort {
    Product save(Product product);
    void delete(UUID id);
    Product update(Product product);

    List<Product> getByCategory(Category category);

    Product findById(UUID id);
}
