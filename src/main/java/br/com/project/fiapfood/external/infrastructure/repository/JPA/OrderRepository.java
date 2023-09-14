package br.com.project.fiapfood.external.infrastructure.repository.JPA;

import br.com.project.fiapfood.external.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
