package br.com.project.fiapfood.external.infrastructure.entity;


import br.com.project.fiapfood.domain.enums.Category;
import br.com.project.fiapfood.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String flagCard;

    @Enumerated(EnumType.STRING)
    private Category category;


    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Status status;

}
