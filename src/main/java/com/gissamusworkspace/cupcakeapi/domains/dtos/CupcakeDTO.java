package com.gissamusworkspace.cupcakeapi.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CupcakeDTO {

    private UUID id;

    private String nome;

    private String sabor;

    private List<String> ingredientes;

    private Boolean disabled;

}
