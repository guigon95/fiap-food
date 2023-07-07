package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ItemOrderMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ItemOrderRepository;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.port.out.ItemOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ItemOrderAdapter implements ItemOrderPort {

    private final ItemOrderRepository itemOrderRepository;
    private final ItemOrderMapper itemOrderMapper;
    @Override
    public ItemOrder findById(UUID id) {
        return itemOrderMapper.itemOrderEntityToItemOrder(
                itemOrderRepository.findById(id)
                        .orElse(null));
    }

    @Override
    public ItemOrder save(ItemOrder itemOrder) {
        var itemOrderEntity = itemOrderMapper.itemOrderToItemOrderEntity(itemOrder);
        return itemOrderMapper.itemOrderEntityToItemOrder(itemOrderRepository.save(itemOrderEntity));
    }

    @Override
    public void deleteByOrderId(Long id) {
        itemOrderRepository.deleteByOrderId(id);
    }
}
