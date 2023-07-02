package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.OrderEntity;
import br.com.project.fiapfood.adapters.inbound.request.OrderRequest;
import br.com.project.fiapfood.adapters.inbound.response.OrderResponse;
import br.com.project.fiapfood.application.core.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderEntityToOrder(OrderEntity orderEntity);

    OrderEntity orderToOrderEntity(Order order);

    Order orderRequestToOrder(OrderRequest orderRequest);

    OrderResponse orderToOrderResponse(Order order);

}
