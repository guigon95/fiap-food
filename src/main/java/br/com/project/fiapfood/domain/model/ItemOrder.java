package br.com.project.fiapfood.domain.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemOrder {

    private Product product;

    private Order order;

    private Integer quantity;


}
