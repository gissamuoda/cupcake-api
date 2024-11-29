package com.gissamusworkspace.cupcakeapi.domains.forms;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CupcakeForm {

    @NotNull
    private String nome;

    private String sabor;

    private List<String> ingredientes;

}
