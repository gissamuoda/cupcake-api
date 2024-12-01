package com.gissamusworkspace.cupcakeapi.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum TipoEntrega {

    RETIRAR_NA_LOJA(0),
    ENTREGA(1);

    private Integer index;

    private static final Map<Integer, TipoEntrega> mapValues = new HashMap<>();

    static {
        for (TipoEntrega tipoEntrega : TipoEntrega.values()) {
            mapValues.put(tipoEntrega.getIndex(), tipoEntrega);
        }
    }

    public static TipoEntrega get(Integer index) {
        return mapValues.get(index);
    }

    public static List<String> getExpectedValuesMessage() {
        return Arrays.stream(TipoEntrega.values())
                .map(tipoEntrega -> tipoEntrega + " - " + tipoEntrega.getIndex()).toList();
    }

}
