package com.gissamusworkspace.cupcakeapi.controllers.handlers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ValidationErrorDTO;
import com.gissamusworkspace.cupcakeapi.domains.dtos.ValidationErrorDTO.ErrorDTO;
import com.gissamusworkspace.cupcakeapi.exceptions.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ValidationExceptionHandlerTest {

    @InjectMocks
    private ValidationExceptionHandler handler;

    @Test
    void testValidationException() {
        List<ErrorDTO> errorList = new ArrayList<>();
        errorList.add(new ErrorDTO("field", "attemptedValue", List.of("values", "values")));
        ValidationException validationException = new ValidationException("message", errorList);

        assertDoesNotThrow(() -> {
            ValidationErrorDTO validationErrorDTO = handler.handlerValidationException(validationException);

            assertEquals("Erros foram encontrados ao realizar o pedido", validationErrorDTO.getMessage());
        });
    }
}
