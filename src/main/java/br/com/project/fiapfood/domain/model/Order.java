package br.com.project.fiapfood.domain.model;

import br.com.project.fiapfood.domain.enums.OrderStatus;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order {

    private Long id;

    private List<ItemOrder> itemOrder;

    private OrderStatus orderStatus;

    private Client client;
}
