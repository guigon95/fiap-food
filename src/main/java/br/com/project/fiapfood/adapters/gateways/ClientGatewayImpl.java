package br.com.project.fiapfood.adapters.gateways;

import br.com.project.fiapfood.external.gateway.ClientGateway;
import br.com.project.fiapfood.adapters.mapper.ClientMapper;
import br.com.project.fiapfood.infrastructure.repository.JPA.ClientRepository;
import br.com.project.fiapfood.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ClientGatewayImpl implements ClientGateway {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;
    @Override
    public Client save(Client client) {
        return clientMapper.clientEntityToClient(
                clientRepository.save(clientMapper.clientToClientEntity(client)));
    }

    @Override
    public Client findByCpf(String cpf) {
        return clientMapper.clientEntityToClient(
                clientRepository.findByCpf(cpf).orElse(null));
    }

    @Override
    public Client findById(UUID id) {
        return clientMapper.clientEntityToClient(
                clientRepository.findById(id).orElse(null));
    }
}
