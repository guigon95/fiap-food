package br.com.project.fiapfood.external.infrastructure.repository.JPA;

import br.com.project.fiapfood.external.infrastructure.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
