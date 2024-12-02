package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ClienteDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.ClienteForm;
import com.gissamusworkspace.cupcakeapi.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController controller;

    @Mock
    private ClienteService service;

    @Test
    void testSaveClient() {
        when(service.saveCliente(any(ClienteForm.class))).thenReturn(new ClienteDTO());

        assertDoesNotThrow(() -> controller.saveCliente(new ClienteForm()));
    }
}
