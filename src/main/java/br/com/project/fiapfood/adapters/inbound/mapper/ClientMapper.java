package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.ClientEntity;
import br.com.project.fiapfood.adapters.inbound.request.ClientRequest;
import br.com.project.fiapfood.adapters.inbound.response.ClientResponse;
import br.com.project.fiapfood.application.core.domain.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client ClientEntityToClient(ClientEntity clientEntity);

    ClientEntity ClientToClientEntity(Client client);

    Client ClientRequestToClient(ClientRequest clientRequest);

    ClientResponse ClientToClientResponse(Client client);



}
