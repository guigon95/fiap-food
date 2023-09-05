package br.com.project.fiapfood.domain.usecase;

import br.com.project.fiapfood.domain.model.ItemOrder;

import java.util.UUID;

public interface ItemOrderUseCase {
    public ItemOrder findById(UUID id);

    ItemOrder createItemOrdem(ItemOrder itemOrder);

    void deleteByOrderId(Long id);

    ItemOrder update(ItemOrder itemOrder);


}
