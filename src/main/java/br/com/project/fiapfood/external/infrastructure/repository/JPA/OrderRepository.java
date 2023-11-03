package br.com.project.fiapfood.external.infrastructure.repository.JPA;

import br.com.project.fiapfood.domain.enums.OrderStatus;
import br.com.project.fiapfood.external.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByOrderStatusNotOrderByCreatedAt(OrderStatus orderStatus);

    @Modifying
    @Query("update OrderEntity o set o.orderStatus = ?1 where o.id = ?2")
    int updateOrderStatus(OrderStatus status, Long id);

}
