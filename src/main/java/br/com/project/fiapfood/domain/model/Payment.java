package br.com.project.fiapfood.domain.model;

import br.com.project.fiapfood.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class Payment {

    private UUID id;

    private Order order;

    private BigDecimal value;

    private PaymentStatus status;
}
