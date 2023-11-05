package br.com.project.fiapfood.adapter.dto.response;

import br.com.project.fiapfood.domain.enums.PaymentStatus;
import br.com.project.fiapfood.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class PaymentResponse {

    private OrderResponse order;

    private BigDecimal paymentValue;

    private PaymentStatus status;
}
