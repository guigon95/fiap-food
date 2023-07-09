package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ClientMapper;
import br.com.project.fiapfood.adapters.inbound.request.ClientRequest;
import br.com.project.fiapfood.adapters.inbound.response.ClientResponse;
import br.com.project.fiapfood.application.core.exception.ObjectNotFoundException;
import br.com.project.fiapfood.application.port.in.ClientServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Validated
@Log4j2
public class ClientController {

    private final ClientMapper clientMapper;

    private final ClientServicePort clientServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public ClientResponse saveClient(@RequestBody @Valid ClientRequest clientRequest){
        var client = clientMapper.clientRequestToClient(clientRequest);
        return clientMapper.clientToClientResponse(clientServicePort.saveClient(client));

    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Search a client by cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client Search",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public ClientResponse findClientByCpf(@PathVariable @Valid @CPF String cpf){
        var client = clientServicePort.findClientByCpf(cpf);
        return clientMapper.clientToClientResponse(client);
    }

}
