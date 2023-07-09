package br.com.project.fiapfood.adapters.outbound.repository;

import br.com.project.fiapfood.adapters.inbound.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByCpf(String cpf);
}
