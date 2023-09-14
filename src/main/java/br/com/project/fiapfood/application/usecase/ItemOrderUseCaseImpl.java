package br.com.project.fiapfood.application.usecase;

import br.com.project.fiapfood.adapter.gateway.ItemOrderGateway;
import br.com.project.fiapfood.domain.model.ItemOrder;
import br.com.project.fiapfood.domain.usecase.ItemOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ItemOrderUseCaseImpl implements ItemOrderUseCase {

    private final ItemOrderGateway itemOrderGateway;

    @Override
    public ItemOrder findById(UUID id) {
        return itemOrderGateway.findById(id);
    }

    @Override
    public ItemOrder createItemOrdem(ItemOrder itemOrder) {
        return itemOrderGateway.save(itemOrder);
    }

    @Override
    public void deleteByOrderId(Long id) {
        itemOrderGateway.deleteByOrderId(id);
    }

    @Override
    public ItemOrder update(ItemOrder itemOrder) {
        return itemOrderGateway.update(itemOrder);
 }

}
