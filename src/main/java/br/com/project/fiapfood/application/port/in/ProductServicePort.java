package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.application.core.domain.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.UUID;

public interface ProductServicePort {
    Product saveProduct(Product product);
    void deleteProduct(UUID id);
    Product updateProduct(Product product) throws ChangeSetPersister.NotFoundException;

    List<Product> getProductsByCategory(Category category);
}
