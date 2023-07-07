package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.adapters.inbound.entity.enums.OrderStatus;
import br.com.project.fiapfood.adapters.inbound.mapper.OrderMapper;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.core.domain.Order;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.application.port.in.OrderServicePort;
import br.com.project.fiapfood.application.port.out.ItemOrderPort;
import br.com.project.fiapfood.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderService implements OrderServicePort {

    private final OrderPort orderPort;

    private final ItemOrderPort itemOrderPort;

    private final OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrder() {
        return orderPort.findAll();
    }

    @Override
    public Order findOrderById(Long id) {
        var order = orderPort.findById(id);

        if(order == null)
            throw new ObjectNotFoundException("Order not found");

        return order;
    }

    @Override
    public Order saveOrder(Order order) {

        List<ItemOrder> savedItemOrder = new ArrayList<>();
        Order saved = orderPort.save(new Order(null, null, OrderStatus.RECEIVED));

        for (ItemOrder itemOrder: order.getItemOrder()) {
            itemOrder.setOrder(saved);
            ItemOrder item = itemOrderPort.save(itemOrder);
        }

        return orderPort.findById(saved.getId());
    }

    @Override
    public Order updateOrder(Order order) {
        itemOrderPort.deleteByOrderId(order.getId());
        return this.orderPort.update(order);
    }
}
