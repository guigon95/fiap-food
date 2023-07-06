package br.com.project.fiapfood.application.core.domain;

import br.com.project.fiapfood.adapters.inbound.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Order {

    private Long id;

    private List<ItemOrder> itemOrder;

    private OrderStatus orderStatus;
}
