package br.com.project.fiapfood.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class Client {

    private UUID id;
    private String name;
    private String email;
    private String cpf;
}
