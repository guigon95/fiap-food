package br.com.project.fiapfood.application.usecase;

import br.com.project.fiapfood.external.gateway.ClientGateway;
import br.com.project.fiapfood.application.exception.ObjectNotFoundException;
import br.com.project.fiapfood.domain.model.Client;
import br.com.project.fiapfood.domain.usecase.ClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    private final ClientGateway clientGateway;

    @Override
    public Client createClient(Client client) {
        return clientGateway.save(client);
    }

    @Override
    public Client findClientByCpf(String cpf) {
        Client client = clientGateway.findByCpf(cpf);
        if (client == null) {
            throw new ObjectNotFoundException("Client not found");
        }
        return client;
    }

    @Override
    public Client findClientById(UUID id) {
        Client client = clientGateway.findById(id);
        if (client == null) {
            throw new ObjectNotFoundException("Client not found");
        }
        return client;
    }
}
