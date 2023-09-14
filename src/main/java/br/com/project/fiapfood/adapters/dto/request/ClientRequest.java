package br.com.project.fiapfood.adapters.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@Data
public class ClientRequest {

    @NotEmpty (message = "The field name cannot be empty.")
    @Schema (description = "Name from client")
    public String name;

    @NotEmpty @Email (message = "The field email cannot be empty.")
    @Schema (description = "address email from client")
    public String email;

    @NotEmpty (message = "The field cpf cannot be empty.")
    @CPF(message = "The field cpf has be document.")
    @Schema (description = "client identifier")
    public String cpf;
}
