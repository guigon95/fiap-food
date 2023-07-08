package br.com.project.fiapfood.adapters.inbound.entity;


import br.com.project.fiapfood.application.core.domain.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(ItemOrderPK.class)
public class ItemOrderEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("product_id")
    @ToString.Exclude
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("order_id")
    @ToString.Exclude
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order;

    @Column
    private Integer quantity;

}
