package br.com.project.fiapfood.adapters.inbound.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientRequest {

    @NotEmpty (message = "The field name cannot be empty.")
    public String name;

    @NotEmpty @Email (message = "The field email cannot be empty.")
    public String email;

    @NotEmpty (message = "The field cpf cannot be empty.")
    public String cpf;
}
