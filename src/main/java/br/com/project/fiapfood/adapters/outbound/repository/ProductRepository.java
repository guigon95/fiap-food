package br.com.project.fiapfood.adapters.outbound.repository;

import br.com.project.fiapfood.adapters.inbound.entity.ClientEntity;
import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
