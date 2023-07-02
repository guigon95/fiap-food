package br.com.project.fiapfood.adapters.outbound.repository;

import br.com.project.fiapfood.adapters.inbound.entity.ProductEntity;
import br.com.project.fiapfood.adapters.inbound.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    @Transactional
    @Modifying
    @Query("update ProductEntity p set p.status = ?1 where p.id = ?2")
    void updateStatusById(@NonNull Status status, @NonNull UUID id);
}
