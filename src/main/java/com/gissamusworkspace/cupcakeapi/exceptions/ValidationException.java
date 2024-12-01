package com.gissamusworkspace.cupcakeapi.exceptions;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ValidationErrorDTO.ErrorDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException {

    private final List<ErrorDTO> errorList;

    public ValidationException(String message, List<ErrorDTO> errorList) {
        super(message);
        this.errorList = errorList;
    }

}
