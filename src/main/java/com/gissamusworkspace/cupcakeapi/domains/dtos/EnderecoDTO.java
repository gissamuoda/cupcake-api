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
public class EnderecoDTO {

    private UUID id;

    private String cidade;

    private String rua;

    private String bairro;

    private String numeroCasa;

    private String complemento;

}
