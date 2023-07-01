package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Client;

public interface SaveClientPort {
    Client save(Client client);
}
