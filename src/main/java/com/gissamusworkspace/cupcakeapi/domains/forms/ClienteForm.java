package com.gissamusworkspace.cupcakeapi.domains.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteForm {

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private List<EnderecoForm> enderecos;

}
