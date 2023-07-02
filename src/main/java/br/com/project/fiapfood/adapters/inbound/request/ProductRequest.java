package br.com.project.fiapfood.adapters.inbound.request;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class ProductRequest {

    @NotEmpty
    public String name;

    @Enumerated(EnumType.STRING)
    public Category category;
    @NotEmpty
    public String description;
    public BigDecimal price;
    @NotEmpty
    public String images;
}
