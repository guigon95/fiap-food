package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.adapters.inbound.entity.OrderEntity;
import br.com.project.fiapfood.adapters.inbound.response.OrderResponse;
import br.com.project.fiapfood.application.core.domain.Order;

import java.util.List;
import java.util.UUID;

public interface OrderServicePort {
    public List<Order> findAllOrder();
    Order findOrderById(UUID id);
    Order saveOrder(Order order);
}
