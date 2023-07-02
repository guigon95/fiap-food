package br.com.project.fiapfood.adapters.inbound.response;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductResponse {

    public String name;

    @Enumerated(EnumType.STRING)
    public Category category;

    public String description;
    public BigDecimal price;
    public String images;
}
