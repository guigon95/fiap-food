package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.port.out.ItemOrderPort;

import java.util.UUID;

public interface ItemOrderServicePort {

    ItemOrder findItemOrderById(UUID id);
}
