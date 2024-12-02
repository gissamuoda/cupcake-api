package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.AdministradorDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.AdministradorForm;
import com.gissamusworkspace.cupcakeapi.services.AdministradorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdministradorControllerTest {

    @InjectMocks
    private AdministradorController controller;

    @Mock
    private AdministradorService service;

    @Test
    void testSaveAdministrador() {
        when(service.saveAdministrador(any(AdministradorForm.class))).thenReturn(new AdministradorDTO());

        assertDoesNotThrow(() -> controller.saveAdministrador(new AdministradorForm()));
    }

}
