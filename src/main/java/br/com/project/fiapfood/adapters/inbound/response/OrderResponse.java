package br.com.project.fiapfood.adapters.inbound.response;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderResponse {

    public List<ItemOrderResponse> itemOrder;

    @Enumerated(EnumType.STRING)
    public Status status;
}
