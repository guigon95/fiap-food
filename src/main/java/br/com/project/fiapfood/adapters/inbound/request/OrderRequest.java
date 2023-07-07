package br.com.project.fiapfood.adapters.inbound.request;

import br.com.project.fiapfood.adapters.inbound.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class OrderRequest {

    @JsonProperty("item_order")
    public List<ItemOrderRequest> itemOrder;

}
