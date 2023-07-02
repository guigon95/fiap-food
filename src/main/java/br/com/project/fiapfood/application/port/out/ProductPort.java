package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.UUID;

public interface ProductPort {
    Product save(Product product);
    void delete(UUID id);
    Product update(Product product) throws ChangeSetPersister.NotFoundException;

}
