package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.in.SaveProductServicePort;
import br.com.project.fiapfood.application.port.out.SaveProductPort;
import org.springframework.stereotype.Component;

@Component
public class SaveProductService implements SaveProductServicePort {

    private final SaveProductPort saveProductPort;

    public SaveProductService(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.saveProductPort.save(product);
    }
}
