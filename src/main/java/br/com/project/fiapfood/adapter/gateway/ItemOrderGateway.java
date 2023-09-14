package br.com.project.fiapfood.adapter.gateway;

import br.com.project.fiapfood.domain.model.ItemOrder;

import java.util.List;
import java.util.UUID;

public interface ItemOrderGateway {
    ItemOrder findById(UUID id);
    List<ItemOrder> findByOrderId(Long id);
    ItemOrder save(ItemOrder itemOrder);

    void deleteByOrderId(Long id);

    ItemOrder update(ItemOrder itemOrder);

    List<ItemOrder> saveAll(List<ItemOrder> itemOrder);


}
