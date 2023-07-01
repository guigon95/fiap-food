package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.Client;

public interface SaveClientServicePort {
    public Client saveClient(Client client);
}
