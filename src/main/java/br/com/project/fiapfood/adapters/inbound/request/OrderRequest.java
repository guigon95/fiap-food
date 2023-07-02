package br.com.project.fiapfood.adapters.inbound.request;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
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

    private Status status;
}
