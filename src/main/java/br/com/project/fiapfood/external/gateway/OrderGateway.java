package br.com.project.fiapfood.external.gateway;

import br.com.project.fiapfood.domain.model.Order;

import java.util.List;

public interface OrderGateway {

    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);
    Order update(Order order);

}
