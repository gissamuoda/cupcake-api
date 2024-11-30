package com.gissamusworkspace.cupcakeapi.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusPedido {

    REALIZADO(0),
    EM_PREPARACAO(1),
    ESPERANDO_ENTREGA(2),
    PRONTO_PARA_SER_RETIRADO(3),
    FINALIZADO(4);

    private Integer index;

    private static final Map<Integer, StatusPedido> mapValues = new HashMap<>();

    static {
        for (StatusPedido statusPedido : StatusPedido.values()) {
            mapValues.put(statusPedido.getIndex(), statusPedido);
        }
    }

    public static StatusPedido get(Integer index) {
        return mapValues.get(index);
    }

}