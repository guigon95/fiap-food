package br.com.project.fiapfood.domain.usecase;

import br.com.project.fiapfood.domain.enums.Category;
import br.com.project.fiapfood.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductUseCase {
    Product createProduct(Product product);
    void delete(UUID id);
    Product update(Product product);

    List<Product> findByCategory(Category category);

    Product findById(UUID id);
    List<Product> findByCategoryAndStatusActive(Category category);

    Product findByIdAndStatusActive(UUID id);
}
