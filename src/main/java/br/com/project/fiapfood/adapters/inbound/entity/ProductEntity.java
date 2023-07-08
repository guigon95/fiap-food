package br.com.project.fiapfood.adapters.inbound.entity;


import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<ItemOrderEntity> itemOrder;

    private String description;
    private BigDecimal price;
    private String images;

    @Enumerated(EnumType.STRING)
    private Status status;

}
