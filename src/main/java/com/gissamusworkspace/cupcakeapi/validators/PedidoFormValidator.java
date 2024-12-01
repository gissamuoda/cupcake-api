package com.gissamusworkspace.cupcakeapi.validators;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ValidationErrorDTO.ErrorDTO;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoEntrega;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoPagamento;
import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import com.gissamusworkspace.cupcakeapi.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoFormValidator {

    public static void validate(final PedidoForm form) {
        List<ErrorDTO> errorList = new ArrayList<>();

        if (Objects.isNull(validateTipoEntrega(form.getTipoEntrega()))) errorList.add(buildTipoEntregaError(form.getTipoEntrega()));
        if (Objects.isNull(validateTipoPagamento(form.getTipoPagamento()))) errorList.add(buildTipoPagamentoError(form.getTipoPagamento()));

        if (!errorList.isEmpty()) {
            throw new ValidationException("Validation error", errorList);
        }
    }

    private static TipoEntrega validateTipoEntrega(final Integer index) {
        return TipoEntrega.get(index);
    }

    private static ErrorDTO buildTipoEntregaError(final Integer attemptedValue) {
        return ErrorDTO.builder()
                .field("tipoEntrega")
                .attemptedValue(attemptedValue.toString())
                .expectedValues(TipoEntrega.getExpectedValuesMessage())
                .build();
    }

    private static TipoPagamento validateTipoPagamento(final Integer index) {
        return TipoPagamento.get(index);
    }

    private static ErrorDTO buildTipoPagamentoError(final Integer attemptedValue) {
        return ErrorDTO.builder()
                .field("tipoPagamento")
                .attemptedValue(attemptedValue.toString())
                .expectedValues(TipoPagamento.getExpectedValuesMessage())
                .build();
    }

}
