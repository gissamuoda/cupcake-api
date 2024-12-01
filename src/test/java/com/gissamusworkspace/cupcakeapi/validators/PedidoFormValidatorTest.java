package com.gissamusworkspace.cupcakeapi.validators;

import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import com.gissamusworkspace.cupcakeapi.exceptions.ValidationException;
import com.gissamusworkspace.cupcakeapi.infrastructure.PedidoBuild;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PedidoFormValidatorTest {

    @Test
    void testValidForm() {
        assertDoesNotThrow(() -> PedidoFormValidator.validate(PedidoBuild.getForm()));
    }

    @Test
    void testNonValidform() {
        PedidoForm form = PedidoBuild.getForm();
        form.setTipoEntrega(10);
        form.setTipoPagamento(10);

        ValidationException validationException = assertThrows(ValidationException.class, () -> PedidoFormValidator.validate(form));

        assertNotNull(validationException.getErrorList());
        assertEquals(2, validationException.getErrorList().size());
    }

    @Test
    void testNonValidTipoEntregaForm() {
        PedidoForm form = PedidoBuild.getForm();
        form.setTipoEntrega(10);

        ValidationException validationException = assertThrows(ValidationException.class, () -> PedidoFormValidator.validate(form));

        assertNotNull(validationException.getErrorList());
        assertEquals(1, validationException.getErrorList().size());
        assertEquals("tipoEntrega", validationException.getErrorList().getFirst().getField());
        assertEquals(form.getTipoEntrega().toString(), validationException.getErrorList().getFirst().getAttemptedValue());
    }

    @Test
    void testNonValidTipoPagamentoForm() {
        PedidoForm form = PedidoBuild.getForm();
        form.setTipoPagamento(10);

        ValidationException validationException = assertThrows(ValidationException.class, () -> PedidoFormValidator.validate(form));

        assertNotNull(validationException.getErrorList());
        assertEquals(1, validationException.getErrorList().size());
        assertEquals("tipoPagamento", validationException.getErrorList().getFirst().getField());
        assertEquals(form.getTipoPagamento().toString(), validationException.getErrorList().getFirst().getAttemptedValue());
    }
}
