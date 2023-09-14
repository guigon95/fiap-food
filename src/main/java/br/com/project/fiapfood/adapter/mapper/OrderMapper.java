package br.com.project.fiapfood.adapter.mapper;

import br.com.project.fiapfood.adapter.dto.request.ItemOrderRequest;
import br.com.project.fiapfood.adapter.dto.request.OrderRequest;
import br.com.project.fiapfood.adapter.dto.response.OrderResponse;
import br.com.project.fiapfood.domain.model.Client;
import br.com.project.fiapfood.domain.model.ItemOrder;
import br.com.project.fiapfood.domain.model.Order;
import br.com.project.fiapfood.domain.model.Product;
import br.com.project.fiapfood.domain.usecase.ClientUseCase;
import br.com.project.fiapfood.domain.usecase.ProductUseCase;
import br.com.project.fiapfood.external.infrastructure.entity.OrderEntity;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = ItemOrderMapper.class)
public abstract class OrderMapper {

    @Autowired
    private ProductUseCase productUseCase;

    @Autowired
    private ClientUseCase clientUseCase;

    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

    public abstract OrderEntity orderToOrderEntity(Order order);

    @Mapping(target = "itemOrder", source = "itemOrder", qualifiedByName = "fromItemOrderRequestToItemOrder")
    @Mapping(target = "client", source = "client", qualifiedByName = "fromClientUuidToClient")
    public abstract Order orderRequestToOrder(OrderRequest orderRequest);

    @Named("fromClientUuidToClient")
    protected Client fromClientUuidToClient(String client) {
        if(client != null)
            return clientUseCase.findClientByCpf(client);

        return null;
    }

    @Named("fromItemOrderRequestToItemOrder")
    protected List<ItemOrder> fromItemOrderRequestToItemOrder(List<ItemOrderRequest> itemOrderRequest) {

        List<ItemOrder> itemOrders = new ArrayList<>();

        for (ItemOrderRequest itemOrderReq: itemOrderRequest) {
            Product product = productUseCase.findByIdAndStatusActive(itemOrderReq.productId);
            itemOrders.add(new ItemOrder(product, null, itemOrderReq.getQuantity()));
        }
        return itemOrders;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    public abstract void updateOrderEntityFromOrder(Order order, @MappingTarget OrderEntity orderEntity);

    public abstract OrderResponse orderToOrderResponse(Order order);
}
