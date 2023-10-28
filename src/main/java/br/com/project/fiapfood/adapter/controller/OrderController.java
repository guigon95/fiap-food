package br.com.project.fiapfood.adapter.controller;

import br.com.project.fiapfood.adapter.dto.request.OrderRequest;
import br.com.project.fiapfood.adapter.dto.request.OrderStatusRequest;
import br.com.project.fiapfood.adapter.dto.response.OrderResponse;
import br.com.project.fiapfood.adapter.mapper.OrderMapper;
import br.com.project.fiapfood.domain.enums.OrderStatus;
import br.com.project.fiapfood.domain.usecase.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;

    private final OrderUseCase orderUseCase;


    public ResponseEntity<List<OrderResponse>> findAllOrders(){

        return ResponseEntity.ok(
                orderUseCase.findByOrderStatusNotOrderByCreatedAt()
                .stream()
                .map(orderMapper::orderToOrderResponse).collect(Collectors.toList()));
    }


    public ResponseEntity<OrderResponse> getOrderById(Long id){
        return ResponseEntity.ok( orderMapper.orderToOrderResponse(orderUseCase.findById(id)));
    }


    public ResponseEntity<OrderResponse> saveOrder(OrderRequest orderRequest){
        var order = orderMapper.orderRequestToOrder(orderRequest);
        order.setOrderStatus(OrderStatus.RECEIVED);
        return ResponseEntity.ok(orderMapper.orderToOrderResponse(orderUseCase.createOrder(order)));
    }


    public ResponseEntity<OrderResponse> updateOrder(Long id, OrderRequest orderRequest){

        var order = orderMapper.orderRequestToOrder(orderRequest);
        order.setId(id);

        var updatedOrder = orderUseCase.updateOrder(order);
        return ResponseEntity.ok(orderMapper.orderToOrderResponse(updatedOrder));
    }

    public ResponseEntity<OrderResponse> updateOrderStatus(Long id, OrderStatusRequest orderStatusRequest){

        var order = orderUseCase.findById(id);

        order.setOrderStatus(orderStatusRequest.getOrderStatus());

        var updatedOrder = orderUseCase.updateStatus(order);
        return ResponseEntity.ok(orderMapper.orderToOrderResponse(updatedOrder));
    }
}
