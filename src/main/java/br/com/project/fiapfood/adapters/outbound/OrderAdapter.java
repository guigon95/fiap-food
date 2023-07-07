package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.entity.OrderEntity;
import br.com.project.fiapfood.adapters.inbound.mapper.OrderMapper;
import br.com.project.fiapfood.adapters.outbound.repository.OrderRepository;
import br.com.project.fiapfood.application.core.domain.Order;
import br.com.project.fiapfood.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
