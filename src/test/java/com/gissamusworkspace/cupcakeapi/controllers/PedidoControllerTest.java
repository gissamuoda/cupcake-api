package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.PedidoBuild;
import com.gissamusworkspace.cupcakeapi.services.PedidoService;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    @InjectMocks
    private PedidoController controller;

    @Mock
    private PedidoService service;

    @Test
    void testGetEndpoint() {
       when(service.getPedidos(any(Pageable.class))).thenReturn(Page.empty());

       assertDoesNotThrow(() -> controller.getPedidos(Pageable.unpaged()));
    }

    @Test
    void testPostEndpoint() {
        when(service.savePedido(any(PedidoForm.class))).thenReturn(PedidoBuild.getDto());

        assertDoesNotThrow(() -> controller.savePedido(PedidoBuild.getForm()));
    }


    @Test
    void testDeleteEndpointSuccessResult() {
        doNothing().when(service).deletePedido(anyString());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.deletePedido("randomString");

            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        });
    }

    @Test
    void testDeleteEndpointNoResult() {
        doThrow(new RuntimeException()).when(service).deletePedido(anyString());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.deletePedido("randomString");

            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        });
    }

    @Test
    void testUpdatePedidoStatusEndpointSuccessResult() {
        when(service.updateStatusPedido(anyString(), anyInt())).thenReturn(PedidoBuild.getDto());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.updateStatusPedido("randomString", 1);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
        });
    }

    @Test
    void testUpdatePedidoStatusEndpointNoResult() {
        when(service.updateStatusPedido(anyString(), anyInt())).thenThrow(new RuntimeException());

        assertDoesNotThrow(() -> {
            ResponseEntity<?> response = controller.updateStatusPedido("randomString", 1);

            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        });
    }

}
