package br.com.project.fiapfood.adapters.inbound.request;

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
    public UUID productId;

    @NotEmpty
    public Integer quantity;
}
