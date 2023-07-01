package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.adapters.inbound.mapper.ClientMapper;
import br.com.project.fiapfood.adapters.inbound.request.ClientRequest;
import br.com.project.fiapfood.adapters.inbound.response.ClientResponse;
import br.com.project.fiapfood.application.port.in.SaveClientServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientMapper clientMapper;

    private final SaveClientServicePort saveClientServicePort;

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

        var client = clientMapper.ClientRequestToClient(clientRequest);
        return clientMapper.ClientToClientResponse(saveClientServicePort.saveClient(client));

    }

}
