package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.adapters.inbound.mapper.OrderMapper;
import br.com.project.fiapfood.application.core.domain.Order;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.application.port.in.OrderServicePort;
import br.com.project.fiapfood.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderService implements OrderServicePort {

    private final OrderPort orderPort;

    private final OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrder() {
        return orderPort.findAll();
    }

    @Override
    public Order findOrderById(UUID id) {
        var order = orderPort.findById(id);

        if(order == null)
            throw new ObjectNotFoundException("Order not found");

        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderPort.save(order);
    }
}
