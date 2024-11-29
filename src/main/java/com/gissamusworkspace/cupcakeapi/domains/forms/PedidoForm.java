package com.gissamusworkspace.cupcakeapi.domains.forms;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PedidoForm {

    @NotNull
    private String tipoPagamento;

    @NotNull
    private String tipoEntrega;

    @NotNull
    @NotEmpty
    private Map<String, Integer> cupcakesIds;

}
