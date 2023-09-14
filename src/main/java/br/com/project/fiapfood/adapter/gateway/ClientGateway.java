package br.com.project.fiapfood.adapter.gateway;

import br.com.project.fiapfood.domain.model.Client;

import java.util.UUID;

public interface ClientGateway {
    Client save(Client client);
    Client findByCpf(String cpf);
    Client findById(UUID id);

}
