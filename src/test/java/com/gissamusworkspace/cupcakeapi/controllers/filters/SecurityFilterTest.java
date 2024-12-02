package com.gissamusworkspace.cupcakeapi.controllers.filters;

import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.services.ClienteService;
import com.gissamusworkspace.cupcakeapi.services.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SecurityFilterTest {

    @InjectMocks
    private SecurityFilter filter;

    @Mock
    private TokenService tokenService;

    @Mock
    private ClienteService clienteService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Test
    void testWithNoToken() {
        when(request.getHeader("Authorization")).thenReturn(null);

        assertDoesNotThrow(() -> {
            filter.doFilterInternal(request, response, filterChain);

            verify(filterChain, times(1)).doFilter(any(HttpServletRequest.class), any(HttpServletResponse.class));
        });
    }

    @Test
    void testWithToken() {
        when(request.getHeader("Authorization")).thenReturn("Bearer someStringToken");
        when(tokenService.getSubject(anyString())).thenReturn("test@test.com");
        when(clienteService.getClienteEntityForLogin(anyString())).thenReturn(new ClienteEntity());

        assertDoesNotThrow(() -> {
            filter.doFilterInternal(request, response, filterChain);

            verify(filterChain, times(1)).doFilter(any(HttpServletRequest.class), any(HttpServletResponse.class));
        });
    }

}
