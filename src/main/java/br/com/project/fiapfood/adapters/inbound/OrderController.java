package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.adapters.inbound.mapper.OrderMapper;
import br.com.project.fiapfood.adapters.inbound.request.OrderRequest;
import br.com.project.fiapfood.adapters.inbound.response.OrderResponse;
import br.com.project.fiapfood.application.port.in.OrderServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;

    private final OrderServicePort orderServicePort;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List All Orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders Listed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public List<OrderResponse> findAllOrders(){

        return orderServicePort.findAllOrder()
                .stream()
                .map(order -> orderMapper.orderToOrderResponse(order)).collect(Collectors.toList());
    }

    @Operation(summary = "Find a order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderResponse getOrderById(@PathVariable UUID id){

        return orderMapper.orderToOrderResponse(orderServicePort.findOrderById(id));

    }

    @PostMapping
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest){

        var order = orderMapper.orderRequestToOrder(orderRequest);

        return orderMapper.orderToOrderResponse(orderServicePort.saveOrder(order));
    }
}
