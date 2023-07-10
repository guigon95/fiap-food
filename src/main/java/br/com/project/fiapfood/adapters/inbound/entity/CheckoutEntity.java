package br.com.project.fiapfood.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordem", nullable = false, columnDefinition = "BIGINT")
    private Long ordem;

    @Column(name = "order_id")
    private Long orderId;
}
