package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.ClientEntity;
import br.com.project.fiapfood.adapters.inbound.request.ClientRequest;
import br.com.project.fiapfood.adapters.inbound.response.ClientResponse;
import br.com.project.fiapfood.application.core.domain.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client clientEntityToClient(ClientEntity clientEntity);

    ClientEntity clientToClientEntity(Client client);

    Client clientRequestToClient(ClientRequest clientRequest);

    ClientResponse clientToClientResponse(Client client);



}
