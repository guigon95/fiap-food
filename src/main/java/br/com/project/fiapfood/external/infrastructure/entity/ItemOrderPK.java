package br.com.project.fiapfood.external.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class ItemOrderPK implements Serializable {

    private Long order;

    private UUID product;
}
