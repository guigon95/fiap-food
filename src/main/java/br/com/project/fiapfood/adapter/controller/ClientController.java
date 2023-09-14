package br.com.project.fiapfood.adapter.controller;

import br.com.project.fiapfood.adapter.dto.request.ClientRequest;
import br.com.project.fiapfood.adapter.dto.response.ClientResponse;
import br.com.project.fiapfood.adapter.mapper.ClientMapper;
import br.com.project.fiapfood.domain.usecase.ClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientMapper clientMapper;

    private final ClientUseCase clientUseCase;


    public ResponseEntity<ClientResponse> saveClient(ClientRequest clientRequest){
        var client = clientMapper.clientRequestToClient(clientRequest);
        return ResponseEntity.ok(clientMapper.clientToClientResponse(clientUseCase.createClient(client)));

    }

    public ClientResponse findClientByCpf(String cpf){
        var client = clientUseCase.findClientByCpf(cpf);
        return clientMapper.clientToClientResponse(client);
    }

}
