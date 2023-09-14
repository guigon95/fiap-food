package br.com.project.fiapfood.external.infrastructure.repository.JPA;

import br.com.project.fiapfood.external.infrastructure.entity.ProductEntity;
import br.com.project.fiapfood.domain.enums.Category;
import br.com.project.fiapfood.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    @Transactional
    @Modifying
    @Query("update ProductEntity p set p.status = ?1 where p.id = ?2")
    void updateStatusById(@NonNull Status status, @NonNull UUID id);

    List<ProductEntity> findAllByCategory(Category category);
    List<ProductEntity> findAllByCategoryAndStatus(Category category, Status status);

    Optional<ProductEntity> findByIdAndStatus(UUID id, Status status);
}
