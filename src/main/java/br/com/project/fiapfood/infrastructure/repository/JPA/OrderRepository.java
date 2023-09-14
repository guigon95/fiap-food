package br.com.project.fiapfood.infrastructure.repository.JPA;

import br.com.project.fiapfood.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
