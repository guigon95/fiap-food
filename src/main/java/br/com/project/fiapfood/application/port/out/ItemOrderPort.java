package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.ItemOrder;

import java.util.UUID;

public interface ItemOrderPort {
    public ItemOrder findById(UUID id);
}
