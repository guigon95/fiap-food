package br.com.project.fiapfood.adapters.inbound.entity;

import br.com.project.fiapfood.adapters.inbound.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemOrderEntity> itemOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
