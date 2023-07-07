package br.com.project.fiapfood.adapters.inbound.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;

    @Column(unique = true)
    private String cpf;
}
