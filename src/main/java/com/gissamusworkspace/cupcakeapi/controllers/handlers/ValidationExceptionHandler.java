package com.gissamusworkspace.cupcakeapi.controllers.handlers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ValidationErrorDTO;
import com.gissamusworkspace.cupcakeapi.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

    private static final String MESSAGE = "Erros foram encontrados ao realizar o pedido";

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ValidationErrorDTO handlerValidationException(ValidationException exception) {
        return ValidationErrorDTO.builder().message(MESSAGE).errorList(exception.getErrorList()).build();
    }

}
