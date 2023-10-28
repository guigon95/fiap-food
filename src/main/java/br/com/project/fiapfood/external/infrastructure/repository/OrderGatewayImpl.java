package br.com.project.fiapfood.external.infrastructure.repository;

import br.com.project.fiapfood.adapter.gateway.ItemOrderGateway;
import br.com.project.fiapfood.adapter.gateway.OrderGateway;
import br.com.project.fiapfood.adapter.mapper.OrderMapper;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.domain.enums.OrderStatus;
import br.com.project.fiapfood.domain.model.ItemOrder;
import br.com.project.fiapfood.domain.model.Order;
import br.com.project.fiapfood.external.infrastructure.repository.JPA.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderGatewayImpl implements OrderGateway {

    private final OrderRepository orderRepository;
    private final ItemOrderGateway itemOrderGateway;


    private final OrderMapper orderMapper;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::orderEntityToOrder).toList();    }

    @Override
    public List<Order> findByOrderStatusNotOrderByCreatedAt() {
        return orderRepository.findByOrderStatusNotOrderByCreatedAt(OrderStatus.FINISHED)
                .stream()
                .map(orderMapper::orderEntityToOrder).toList();
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.orderEntityToOrder(
                orderRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException(Order.class.toString())));    }

    @Override
    @Transactional
    public Order save(Order order) {
        var orderEntity = orderMapper.orderToOrderEntity(order);
        orderEntity.setCreatedAt(LocalDateTime.now());
        Order orderSaved = orderMapper.orderEntityToOrder(orderRepository.save(orderEntity));
        addItemOrder(order.getItemOrder(), orderSaved);
        return orderSaved;
    }


    private void addItemOrder(List<ItemOrder> orderList, Order order) {
        List<ItemOrder> itemOrderList = new ArrayList<>();
        order.setItemOrder(null);
        for (ItemOrder itemOrder: orderList) {
            itemOrder.setOrder(order);
            ItemOrder item = itemOrderGateway.save(itemOrder);
            itemOrderList.add(item);
        }

        order.setItemOrder(itemOrderList);
    }
    @Override
    @Transactional
    public Order update(Order order) {
        itemOrderGateway.deleteByOrderId(order.getId());

        Order saved = findById(order.getId());
        order.setOrderStatus(saved.getOrderStatus());
        order.setClient(order.getClient());
        addItemOrder(order.getItemOrder(), order);

        return order;
    }

    @Override
    @Transactional
    public Order updateStatus(Order order) {

        Order saved = findById(order.getId());
        saved.setOrderStatus(order.getOrderStatus() );
        int i = orderRepository.updateOrderStatus(order.getOrderStatus(), order.getId());

        if(i == 0)
            throw new ObjectNotFoundException("");

        return saved;
    }
}
