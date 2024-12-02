package com.gissamusworkspace.cupcakeapi.domains.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorForm {

    private String nome;

    private String email;

    private String senha;

    private String telefone;

}
