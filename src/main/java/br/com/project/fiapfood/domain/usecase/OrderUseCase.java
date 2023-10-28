package br.com.project.fiapfood.domain.usecase;

import br.com.project.fiapfood.domain.model.Order;

import java.util.List;

public interface OrderUseCase {

    public List<Order> findAll();

    public List<Order> findByOrderStatusNotOrderByCreatedAt();

    public Order findById(Long id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    Order updateStatus(Order order);

}
