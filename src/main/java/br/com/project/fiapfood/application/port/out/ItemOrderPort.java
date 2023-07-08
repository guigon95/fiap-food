package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.ItemOrder;

import java.util.UUID;

public interface ItemOrderPort {
    public ItemOrder findById(UUID id);

    ItemOrder save(ItemOrder itemOrder);

    void deleteByOrderId(Long id);

    ItemOrder update(ItemOrder itemOrder);


}
