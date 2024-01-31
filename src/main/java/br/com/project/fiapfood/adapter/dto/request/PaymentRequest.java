package br.com.project.fiapfood.adapter.dto.request;

import br.com.project.fiapfood.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class PaymentRequest {

    @NotNull(message = "The field order id cannot be empty.")
    @JsonProperty("order_id")
    @Schema(description = "The order id of the payment")
    private Long order;

    @NotNull(message = "The field value cannot be null.")
    @Schema(description = "The payment value")
    private BigDecimal paymentValue;

    @NotNull(message = "The field status cannot be null.")
    @Enumerated(EnumType.STRING)
    @Schema(description = "payment status")
    private PaymentStatus status;
}
