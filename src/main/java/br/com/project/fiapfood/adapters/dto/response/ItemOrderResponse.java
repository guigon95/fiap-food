package br.com.project.fiapfood.adapters.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemOrderResponse {

    public ProductResponse product;

    public Integer quantity;
}
