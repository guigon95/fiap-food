package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.OrderEntity;
import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import br.com.project.fiapfood.adapters.inbound.request.ItemOrderRequest;
import br.com.project.fiapfood.adapters.inbound.request.OrderRequest;
import br.com.project.fiapfood.adapters.inbound.response.OrderResponse;
import br.com.project.fiapfood.application.core.domain.Client;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.core.domain.Order;
import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.in.ClientServicePort;
import br.com.project.fiapfood.application.port.in.ProductServicePort;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = ItemOrderMapper.class)
public abstract class OrderMapper {

    @Autowired
    private ProductServicePort productServicePort;

    @Autowired
    private ClientServicePort clientServicePort;

    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

    public abstract OrderEntity orderToOrderEntity(Order order);

    @Mapping(target = "itemOrder", source = "itemOrder", qualifiedByName = "fromItemOrderRequestToItemOrder")
    @Mapping(target = "client", source = "client", qualifiedByName = "fromClientUuidToClient")
    public abstract Order orderRequestToOrder(OrderRequest orderRequest);

    @Named("fromClientUuidToClient")
    protected Client fromClientUuidToClient(UUID client) {
        if(client != null)
            return clientServicePort.findById(client);

        return null;
    }

    @Named("fromItemOrderRequestToItemOrder")
    protected List<ItemOrder> fromItemOrderRequestToItemOrder(List<ItemOrderRequest> itemOrderRequest) {

        List<ItemOrder> itemOrders = new ArrayList<>();

        for (ItemOrderRequest itemOrderReq: itemOrderRequest) {
            Product product = productServicePort.findById(itemOrderReq.productId);
            itemOrders.add(new ItemOrder(product, null, itemOrderReq.getQuantity()));
        }
        return itemOrders;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    public abstract void updateOrderEntityFromOrder(Order order, @MappingTarget OrderEntity orderEntity);

    public abstract OrderResponse orderToOrderResponse(Order order);
}
