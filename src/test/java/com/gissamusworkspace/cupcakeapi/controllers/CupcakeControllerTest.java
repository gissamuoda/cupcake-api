package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.CupcakeBuild;
import com.gissamusworkspace.cupcakeapi.services.CupcakeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CupcakeControllerTest {

    @InjectMocks
    private CupcakeController controller;

    @Mock
    private CupcakeService service;

    @Test
    void testGetEndpoint() {
        when(service.getCupcakes()).thenReturn(Page.empty());

        assertDoesNotThrow(() -> controller.getCupcakes());
    }

    @Test
    void testPostEndpoint() {
        when(service.saveCupcake(any(CupcakeForm.class))).thenReturn(CupcakeBuild.getDto(true));

        assertDoesNotThrow(() -> controller.saveCupcake(CupcakeBuild.getForm(true)));

    }

}
