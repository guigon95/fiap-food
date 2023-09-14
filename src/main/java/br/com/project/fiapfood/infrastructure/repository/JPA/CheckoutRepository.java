package br.com.project.fiapfood.infrastructure.repository.JPA;

import br.com.project.fiapfood.infrastructure.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
    Optional<CheckoutEntity> findByOrderId(Long id);
}
