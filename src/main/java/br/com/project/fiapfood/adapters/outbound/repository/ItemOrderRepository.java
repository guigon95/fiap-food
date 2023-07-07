package br.com.project.fiapfood.adapters.outbound.repository;

import br.com.project.fiapfood.adapters.inbound.entity.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, UUID> {
}
