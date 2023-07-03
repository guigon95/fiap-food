package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.application.core.domain.Client;
import br.com.project.fiapfood.application.port.in.ClientServicePort;
import br.com.project.fiapfood.application.port.out.ClientPort;
import org.springframework.stereotype.Component;

@Component
public class ClientService implements ClientServicePort {

    private final ClientPort clientPort;

    public ClientService(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public Client saveClient(Client client) {
        return this.clientPort.save(client);
    }

    @Override
    public Client findClientByCpf(String cpf) {
        return this.clientPort.findClientByCpf(cpf);
    }
}
