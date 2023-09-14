package br.com.project.fiapfood.adapter.dto.response;

import br.com.project.fiapfood.domain.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderResponse {

    public Long id;

    public List<ItemOrderResponse> itemOrder;

    @Enumerated(EnumType.STRING)
    public OrderStatus orderStatus;

    public ClientResponse client;
}
