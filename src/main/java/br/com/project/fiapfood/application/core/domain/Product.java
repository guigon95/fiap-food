package br.com.project.fiapfood.application.core.domain;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor
@Builder
@Data
public class Product {
    private UUID id;
    private String name;
    private Category category;
    private String description;
    private BigDecimal price;
    private String images;
    private Status status;
}
