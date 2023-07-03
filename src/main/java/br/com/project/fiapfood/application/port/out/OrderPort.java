package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderPort {

    public List<Order> findAll();

    public Order findById(UUID id);

    Order save(Order order);
}
