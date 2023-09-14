package br.com.project.fiapfood.adapters.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemOrderResponse {

    public ProductResponse product;

    public Integer quantity;
}
