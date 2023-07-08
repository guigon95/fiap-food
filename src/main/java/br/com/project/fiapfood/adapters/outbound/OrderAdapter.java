package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.entity.OrderEntity;
import br.com.project.fiapfood.adapters.inbound.mapper.OrderMapper;
import br.com.project.fiapfood.adapters.outbound.repository.OrderRepository;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.core.domain.Order;
import br.com.project.fiapfood.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(order -> orderMapper.orderEntityToOrder(order)).collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.orderEntityToOrder(
                orderRepository.findById(id)
                        .orElse(null));
    }

    @Override
    public Order save(Order order) {
        var orderEntity = orderMapper.orderToOrderEntity(order);

        return orderMapper.orderEntityToOrder(orderRepository.save(orderEntity));
    }

    @Override
    public Order update(Order order) {

        Optional<OrderEntity> orderOld = orderRepository.findById(order.getId());
        if(orderOld.isEmpty())
            return null;

        //orderMapper.updateOrderEntityFromOrder(order, orderOld.get());
        order.setOrderStatus(orderOld.get().getOrderStatus());

        List<ItemOrder> itemOrderList = new ArrayList<>();
        for (ItemOrder itemOrder: order.getItemOrder()) {
            //itemOrder.setOrder(order);
            itemOrder.setOrder(order);
            itemOrderList.add(itemOrder);
        }

        order.setItemOrder(itemOrderList);

        var orderEntity = orderMapper.orderToOrderEntity(order);

        return orderMapper.orderEntityToOrder(orderRepository.save(orderEntity));
    }
}
