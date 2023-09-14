package br.com.project.fiapfood.domain.usecase;

import br.com.project.fiapfood.domain.model.Client;

import java.util.UUID;

public interface ClientUseCase {
    Client createClient(Client client);
    Client findClientByCpf(String cpf);
    Client findClientById(UUID id);
}
