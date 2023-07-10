package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.Order;

import java.util.List;

public interface OrderServicePort {
    public List<Order> findAllOrder();
    Order findOrderById(Long id);
    Order saveOrder(Order order);
    Order updateOrder(Order order);
}
