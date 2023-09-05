package br.com.project.fiapfood.external.api;

import br.com.project.fiapfood.adapter.controller.ClientController;
import br.com.project.fiapfood.adapter.dto.request.ClientRequest;
import br.com.project.fiapfood.adapter.dto.response.ClientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Validated
@Tag(name = "Clients", description = "Access to client management")
public class ClientApi {

    private final ClientController clientController;

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
    public ResponseEntity<ClientResponse> saveClient(@RequestBody @Valid ClientRequest clientRequest){
        return clientController.saveClient(clientRequest);
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
    public ClientResponse findClientByCpf(@PathVariable @Valid @CPF @Schema (description = "client identifier")  String cpf){
        return clientController.findClientByCpf(cpf);
    }

}
