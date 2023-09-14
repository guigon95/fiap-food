package br.com.project.fiapfood.adapters.mapper;

import br.com.project.fiapfood.infrastructure.entity.ClientEntity;
import br.com.project.fiapfood.adapters.dto.request.ClientRequest;
import br.com.project.fiapfood.adapters.dto.response.ClientResponse;
import br.com.project.fiapfood.domain.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client clientEntityToClient(ClientEntity clientEntity);

    ClientEntity clientToClientEntity(Client client);

    Client clientRequestToClient(ClientRequest clientRequest);

    ClientResponse clientToClientResponse(Client client);



}
