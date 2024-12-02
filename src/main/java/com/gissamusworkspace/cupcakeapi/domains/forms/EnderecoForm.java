package com.gissamusworkspace.cupcakeapi.domains.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoForm {

    private String cidade;

    private String rua;

    private String bairro;

    private String numeroCasa;

    private String complemento;

}