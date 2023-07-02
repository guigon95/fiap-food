package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ProductMapper;
import br.com.project.fiapfood.adapters.inbound.mapper.ProductMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ProductRepository;
import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.out.SaveProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveProductAdapter implements SaveProductPort {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    @Override
    public Product save(Product product) {
        var productEntity = productMapper.ProductToProductEntity(product);
        return productMapper.ProductEntityToProduct(productRepository.save(productEntity));
    }
}
