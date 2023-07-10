package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.port.in.ItemOrderServicePort;
import br.com.project.fiapfood.application.port.out.ItemOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ItemOrderService implements ItemOrderServicePort {

    private final ItemOrderPort itemOrderPort;
    @Override
    public ItemOrder findItemOrderById(UUID id) {
        return itemOrderPort.findById(id);
    }

    @Override
    public ItemOrder saveItemOrder(ItemOrder itemOrder) {
        return itemOrderPort.save(itemOrder);
    }
}
