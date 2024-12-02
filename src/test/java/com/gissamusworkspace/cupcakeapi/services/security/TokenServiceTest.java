package com.gissamusworkspace.cupcakeapi.services.security;

import com.gissamusworkspace.cupcakeapi.infrastructure.ClienteBuild;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @InjectMocks
    private TokenService service;

    private String token;

    @BeforeEach
    void before() {
        this.service = new TokenService("secret", "issuer");
        this.token = service.generateToken(ClienteBuild.getEntity());
    }

    @Test
    void testGenerateToken() {
        assertDoesNotThrow(() -> service.generateToken(ClienteBuild.getEntity()));
    }

    @Test
    void testGetSubject() {
        assertDoesNotThrow(() -> {
            String email = service.getSubject(token);

            assertNotNull(email);
            assertEquals(ClienteBuild.getEntity().getEmail(), email);
        });
    }

}
