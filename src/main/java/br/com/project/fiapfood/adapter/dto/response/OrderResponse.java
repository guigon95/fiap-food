package br.com.project.fiapfood.adapter.dto.response;

import br.com.project.fiapfood.domain.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class OrderResponse {

    private Long id;

    private List<ItemOrderResponse> itemOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private ClientResponse client;

    private PaymentResponse paymentResponse;

    private LocalDateTime createdAt;
}
