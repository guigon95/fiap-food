package br.com.project.fiapfood.adapters.inbound.response;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientResponse {

    @NotEmpty
    public String name;

    @NotEmpty
    public String email;

    @NotEmpty
    public String cpf;
}
