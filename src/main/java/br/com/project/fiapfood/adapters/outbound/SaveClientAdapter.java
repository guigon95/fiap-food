package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ClientMapper;
import br.com.project.fiapfood.adapters.outbound.repository.ClientRepository;
import br.com.project.fiapfood.application.core.domain.Client;
import br.com.project.fiapfood.application.port.out.SaveClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveClientAdapter implements SaveClientPort {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;
    @Override
    public Client save(Client client) {
        var clientEntity = clientMapper.ClientToClientEntity(client);
        return clientMapper.ClientEntityToClient(clientRepository.save(clientEntity));
    }
}
