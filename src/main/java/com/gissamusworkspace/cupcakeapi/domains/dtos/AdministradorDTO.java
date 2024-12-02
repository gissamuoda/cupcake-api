package com.gissamusworkspace.cupcakeapi.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO {

    private UUID id;

    private String nome;

    private String email;

    private String telefone;

}
