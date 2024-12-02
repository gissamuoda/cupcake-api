package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.infrastructure.ClienteBuild;
import com.gissamusworkspace.cupcakeapi.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Test
    void testSaveCliente() {
        when(repository.save(any(ClienteEntity.class))).thenReturn(new ClienteEntity());

        assertDoesNotThrow(() -> service.saveCliente(ClienteBuild.getForm()));
    }

    @Test
    void testGetClienteEntityForLogin() {
        when(repository.findByEmail(anyString())).thenReturn(ClienteBuild.getEntity());

        assertDoesNotThrow(() -> service.getClienteEntityForLogin("someString"));
    }

}
