package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ClientMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ClientRepository;
import br.com.project.fiapfood.application.core.domain.Client;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.application.port.out.ClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientAdapter implements ClientPort {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;
    @Override
    public Client save(Client client) {
        return clientMapper.clientEntityToClient(clientRepository.save(
                clientMapper.clientToClientEntity(client)));
    }

    @Override
    public Client findClientByCpf(String cpf) {
        return clientMapper.clientEntityToClient(clientRepository.findByCpf(cpf).
                orElseThrow(() -> new ObjectNotFoundException("Client not found")));
    }

    @Override
    public Client findById(UUID id) {
        return clientMapper.clientEntityToClient(
                clientRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("Client not found")));
    }
}
