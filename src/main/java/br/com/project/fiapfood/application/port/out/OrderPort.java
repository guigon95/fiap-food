package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Order;

import java.util.List;

public interface OrderPort {

    public List<Order> findAll();

    public Order findById(Long id);

    Order save(Order order);

}
