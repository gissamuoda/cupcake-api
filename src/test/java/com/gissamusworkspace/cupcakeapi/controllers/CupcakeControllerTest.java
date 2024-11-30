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
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CupcakeControllerTest {

    @InjectMocks
    private CupcakeController controller;

    @Mock
    private CupcakeService service;

    @Test
    void testGetEndpoint() {
        when(service.getCupcakes(any(Pageable.class))).thenReturn(Page.empty());

        assertDoesNotThrow(() -> controller.getCupcakes(Pageable.unpaged()));
    }

    @Test
    void testPostEndpoint() {
        when(service.saveCupcake(any(CupcakeForm.class))).thenReturn(CupcakeBuild.getDto(true));

        assertDoesNotThrow(() -> controller.saveCupcake(CupcakeBuild.getForm(true)));
    }

    @Test
    void testDeleteEndpointSuccessResult() {
        doNothing().when(service).deleteCupcake(anyString());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.deleteCupcake("randomString");

            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        });
    }

    @Test
    void testDeleteEndpointNoResult() {
        doThrow(new RuntimeException()).when(service).deleteCupcake(anyString());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.deleteCupcake("randomString");

            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        });
    }

    @Test
    void testDisableCupcakeEndpointSuccessResult() {
        when(service.disableCupcake(anyString())).thenReturn(CupcakeBuild.getDto(true));

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.disableCupcake("randomString");

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
        });
    }

    @Test
    void testDisableCupcakeEndpointNoResult() {
        when(service.disableCupcake(anyString())).thenThrow(new RuntimeException());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.disableCupcake("randomString");

            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        });
    }
}
