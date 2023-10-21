package br.com.project.fiapfood.application.usecase;

import br.com.project.fiapfood.adapter.gateway.ProductGateway;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.domain.enums.Category;
import br.com.project.fiapfood.domain.enums.Status;
import br.com.project.fiapfood.domain.model.Product;
import br.com.project.fiapfood.domain.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {


    private final ProductGateway productGateway;
    @Override
    public Product createProduct(Product product) {
        return productGateway.save(product);
   }

    @Override
    public void delete(UUID id) {
        productGateway.delete(id);
    }

    @Override
    public Product update(Product product) {
        Product productOld = Optional.of(productGateway.findById(product.getId())).
                orElseThrow(() -> new ObjectNotFoundException("Product not found"));

        return productGateway.update(product, productOld);

    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productGateway.findAllByCategory(category);
    }

    @Override
    public List<Product> findByCategoryAndStatusActive(Category category) {
        return productGateway.findAllByCategoryAndStatus(category, Status.ACTIVE);
    }

    @Override
    public Product findByIdAndStatusActive(UUID id) {
        Product product = productGateway.findByIdAndStatus(id, Status.ACTIVE);
        if (product == null) {
           throw new ObjectNotFoundException("Product not found id: "+id);
        }
        return product;
    }

    @Override
    public Product findById(UUID id) {
        Product product = productGateway.findById(id);
        if (product == null) {
            throw new ObjectNotFoundException("Product not found id: "+id);
        }
        return product;
    }
}
