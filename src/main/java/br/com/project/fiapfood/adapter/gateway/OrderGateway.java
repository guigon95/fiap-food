package br.com.project.fiapfood.adapter.gateway;

import br.com.project.fiapfood.domain.model.Order;

import java.util.List;

public interface OrderGateway {

    List<Order> findAll();

    List<Order> findByOrderStatusNotOrderByCreatedAt();

    Order findById(Long id);

    Order save(Order order);
    Order update(Order order);

    Order updateStatus(Order order);

}
