package br.com.project.fiapfood.adapters.inbound.request;

import br.com.project.fiapfood.adapters.inbound.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class OrderRequest {

    @NotEmpty(message = "The field item_order cannot be empty.")
    @JsonProperty("item_order")
    @Valid
    public List<ItemOrderRequest> itemOrder;

    public UUID client;

}
