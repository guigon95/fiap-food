package br.com.project.fiapfood.adapter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemOrderResponse {

    public ProductResponse product;

    public Integer quantity;
}
