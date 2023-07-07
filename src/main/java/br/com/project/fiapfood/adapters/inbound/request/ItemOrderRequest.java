package br.com.project.fiapfood.adapters.inbound.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ItemOrderRequest {

    @JsonProperty("product_id")
    public UUID productId;

    @JsonProperty("quantity")
    public Integer quantity;
}
