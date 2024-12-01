package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoEntity;
import com.gissamusworkspace.cupcakeapi.infrastructure.CupcakeBuild;
import com.gissamusworkspace.cupcakeapi.infrastructure.PedidoBuild;
import com.gissamusworkspace.cupcakeapi.repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @InjectMocks
    private PedidoService service;

    @Mock
    private PedidoRepository repository;

    @Mock
    private CupcakeService cupcakeService;

    @Test
    void testGetPedidos() {
        when(repository.findAll(any(Pageable.class))).thenReturn(Page.empty());

        assertDoesNotThrow(() -> service.getPedidos(Pageable.unpaged()));
    }

    @Test
    void testSavePedido() {
        when(cupcakeService.getCupcakeById(any(UUID.class))).thenReturn(CupcakeBuild.getEntity(true, true));
        when(repository.save(any(PedidoEntity.class))).thenReturn(PedidoBuild.getEntity());

        assertDoesNotThrow(() -> service.savePedido(PedidoBuild.getForm()));
    }

    @Test
    void testDeletePedido() {
        when(repository.findById(any(UUID.class))).thenReturn(Optional.of(PedidoBuild.getEntity()));
        doNothing().when(repository).deleteById(any(UUID.class));

        assertDoesNotThrow(() -> service.deletePedido(UUID.randomUUID().toString()));
    }

    @Test
    void testDeletePedidoNotFoundPedido() {
        when(repository.findById(any(UUID.class))).thenThrow(new NoSuchElementException());

        assertThrows(NoSuchElementException.class, () -> service.deletePedido(UUID.randomUUID().toString()));
    }

    @Test
    void testUpdateStatusPedido() {
        when(repository.findById(any(UUID.class))).thenReturn(Optional.of(PedidoBuild.getEntity()));
        when(repository.save(any(PedidoEntity.class))).thenReturn(PedidoBuild.getEntity());

        assertDoesNotThrow(() -> service.updateStatusPedido(UUID.randomUUID().toString(), 2));
    }

    @Test
    void testUpdateStatusPedidoNotFoundPedido() {
        when(repository.findById(any(UUID.class))).thenThrow(new NoSuchElementException());

        assertThrows(NoSuchElementException.class, () -> service.updateStatusPedido(UUID.randomUUID().toString(), 2));
    }

}
