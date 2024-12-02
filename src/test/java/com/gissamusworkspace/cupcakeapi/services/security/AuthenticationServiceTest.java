package com.gissamusworkspace.cupcakeapi.services.security;

import com.gissamusworkspace.cupcakeapi.infrastructure.ClienteBuild;
import com.gissamusworkspace.cupcakeapi.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationService service;

    @Mock
    private ClienteRepository repository;

    @Test
    void testLoaduserByUsername() {
        when(repository.findByEmail(anyString())).thenReturn(ClienteBuild.getEntity());

        assertDoesNotThrow(() -> service.loadUserByUsername("someString"));
    }

}
