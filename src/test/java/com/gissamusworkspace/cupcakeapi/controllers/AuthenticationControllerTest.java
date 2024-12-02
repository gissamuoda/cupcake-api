package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.LoginForm;
import com.gissamusworkspace.cupcakeapi.services.security.TokenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController controller;

    @Mock
    private TokenService service;

    @Mock
    private AuthenticationManager manager;

    @Test
    void testLogin() {
        when(manager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(getAuthentication());
        when(service.generateToken(any(UserDetails.class))).thenReturn("randomToken");

        assertDoesNotThrow(() -> controller.login(new LoginForm()));
    }

    private Authentication getAuthentication() {
        return new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return new ClienteEntity();
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "";
            }
        };
    }

}
