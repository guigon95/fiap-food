package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Client;

import java.util.UUID;

public interface ClientPort {
    Client save(Client client);
    Client findClientByCpf(String cpf);
    Client findById(UUID id);
}
