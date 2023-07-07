package br.com.project.fiapfood.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class ItemOrder {

    private UUID id;

    private Product product;

    private Order order;

    private Integer quantity;


}
