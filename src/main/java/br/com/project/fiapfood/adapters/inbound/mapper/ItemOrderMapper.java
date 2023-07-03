package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.ItemOrderEntity;
import br.com.project.fiapfood.adapters.inbound.request.ItemOrderRequest;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.port.in.ItemOrderServicePort;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ItemOrderServicePort.class)
public interface ItemOrderMapper {

    ItemOrder itemOrderRequestToItemOrder(ItemOrderRequest itemOrderRequest);

    ItemOrder itemOrderEntityToItemOrder(ItemOrderEntity itemOrderEntity);

    ItemOrderEntity itemOrderToItemOrderEntity(ItemOrder itemOrder);
}
