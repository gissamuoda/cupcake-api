package com.gissamusworkspace.cupcakeapi.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorDTO {

    private String message;

    private List<ErrorDTO> errorList;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorDTO {

        private String field;

        private String attemptedValue;

        private List<String> expectedValues;

    }

}
