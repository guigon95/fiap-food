package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.Client;

public interface ClientServicePort {
    Client saveClient(Client client);

    Client findClientByCpf(String cpf);
}
