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
public enum TipoPagamento {

    NO_LOCAL(0),
    CREDITO(1),
    DEBITO(2),
    PIX(3);

    private Integer index;

    private static final Map<Integer, TipoPagamento> mapValues = new HashMap<>();

    static {
        for (TipoPagamento tipoPagamento : TipoPagamento.values()) {
            mapValues.put(tipoPagamento.getIndex(), tipoPagamento);
        }
    }

    public static TipoPagamento get(Integer index) {
        return mapValues.get(index);
    }

    public static List<String> getExpectedValuesMessage() {
        return Arrays.stream(TipoPagamento.values())
                .map(tipoPagamento -> tipoPagamento + " - " + tipoPagamento.getIndex()).toList();
    }

}
