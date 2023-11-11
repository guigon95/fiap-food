package br.com.project.fiapfood.adapter.dto.request;

import br.com.project.fiapfood.domain.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class OrderStatusRequest {

    @NotNull(message = "The field status cannot be null.")
    @Enumerated(EnumType.STRING)
    @Schema(description = "order status")
    public OrderStatus orderStatus;

}
