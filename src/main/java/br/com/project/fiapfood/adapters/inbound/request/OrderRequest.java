package br.com.project.fiapfood.adapters.inbound.request;

import br.com.project.fiapfood.adapters.inbound.entity.enums.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class OrderRequest {

    @NotEmpty
    private List<ItemOrderRequest> itemOrder;

    private OrderStatus orderStatus;
}
