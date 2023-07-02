package br.com.project.fiapfood.application.core.domain;

import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class Order {

    private UUID id;

    private List<ItemOrder> itemOrder;

    private Status status;
}
