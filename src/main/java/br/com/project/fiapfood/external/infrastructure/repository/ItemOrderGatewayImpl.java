package br.com.project.fiapfood.external.infrastructure.repository;

import br.com.project.fiapfood.adapter.gateway.ItemOrderGateway;
import br.com.project.fiapfood.adapter.mapper.ItemOrderMapper;
import br.com.project.fiapfood.external.infrastructure.entity.ItemOrderEntity;
import br.com.project.fiapfood.external.infrastructure.repository.JPA.ItemOrderRepository;
import br.com.project.fiapfood.domain.model.ItemOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ItemOrderGatewayImpl implements ItemOrderGateway {

    private final ItemOrderRepository itemOrderRepository;
    private final ItemOrderMapper itemOrderMapper;

    @Override
    public ItemOrder findById(UUID id) {
        return itemOrderMapper.itemOrderEntityToItemOrder(
                itemOrderRepository.findById(id)
                        .orElse(null));    }

    @Override
    public List<ItemOrder> findByOrderId(Long id) {
        return itemOrderMapper.itemOrderEntityListToOrderList(
                itemOrderRepository.findByOrderId(id));
    }

    @Override
    public ItemOrder save(ItemOrder itemOrder) {
        var itemOrderEntity = itemOrderMapper.itemOrderToItemOrderEntity(itemOrder);
        return itemOrderMapper.itemOrderEntityToItemOrder(itemOrderRepository.save(itemOrderEntity));
    }

    @Override
    public void deleteByOrderId(Long id) {
        itemOrderRepository.deleteByItemOrderId(id);

    }

    @Override
    public ItemOrder update(ItemOrder itemOrder) {
        var itemOrderEntity = itemOrderMapper.itemOrderToItemOrderEntity(itemOrder);
        return itemOrderMapper.itemOrderEntityToItemOrder(itemOrderRepository.save(itemOrderEntity));
    }

    @Override
    public List<ItemOrder> saveAll(List<ItemOrder> itemOrder) {
        List<ItemOrderEntity> itemOrderEntity = itemOrderMapper.itemOrderListToOrderEntityList(itemOrder);
        return itemOrderMapper.itemOrderEntityListToOrderList(itemOrderRepository.saveAll(itemOrderEntity));    }
}
