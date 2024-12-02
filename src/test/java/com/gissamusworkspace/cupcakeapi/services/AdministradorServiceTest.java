package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.entities.AdminEntity;
import com.gissamusworkspace.cupcakeapi.infrastructure.AdministradorBuild;
import com.gissamusworkspace.cupcakeapi.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdministradorServiceTest {

    @InjectMocks
    private AdministradorService service;

    @Mock
    private ClienteRepository repository;

    @Test
    void testSaveAdministrador() {
        when(repository.save(any(AdminEntity.class))).thenReturn(AdministradorBuild.getEntity());

        assertDoesNotThrow(() -> service.saveAdministrador(AdministradorBuild.getForm()));
    }

}
