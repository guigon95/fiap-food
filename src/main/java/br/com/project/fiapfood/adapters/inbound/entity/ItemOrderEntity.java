package br.com.project.fiapfood.adapters.inbound.entity;


import br.com.project.fiapfood.application.core.domain.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemOrderEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    private Integer quantity;

}
