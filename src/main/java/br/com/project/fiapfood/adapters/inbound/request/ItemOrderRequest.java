package br.com.project.fiapfood.adapters.inbound.request;

import br.com.project.fiapfood.application.core.domain.Order;
import br.com.project.fiapfood.application.core.domain.Product;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ItemOrderRequest {

    @NotEmpty
    private UUID productId;

    @NotEmpty
    private Integer quantity;
}
