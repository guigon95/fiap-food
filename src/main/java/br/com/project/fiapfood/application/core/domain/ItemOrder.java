package br.com.project.fiapfood.application.core.domain;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemOrder {

    private Product product;

    private Order order;

    private Integer quantity;


}
