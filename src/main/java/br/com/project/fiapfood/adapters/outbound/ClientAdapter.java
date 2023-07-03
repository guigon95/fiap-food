package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ClientMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ClientRepository;
import br.com.project.fiapfood.application.core.domain.Client;
import br.com.project.fiapfood.application.port.out.ClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientAdapter implements ClientPort {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;
    @Override
    public Client save(Client client) {
        var clientEntity = clientMapper.clientToClientEntity(client);
        return clientMapper.clientEntityToClient(clientRepository.save(clientEntity));
    }

    @Override
    public Client findClientByCpf(String cpf) {
        return clientMapper.clientEntityToClient(clientRepository.findByCpf(cpf));
    }
}
