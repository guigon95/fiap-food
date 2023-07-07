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
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemOrderEntity> itemOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
