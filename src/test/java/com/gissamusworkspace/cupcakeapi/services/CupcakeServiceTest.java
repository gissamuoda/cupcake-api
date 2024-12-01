package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.CupcakeBuild;
import com.gissamusworkspace.cupcakeapi.repositories.CupcakeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CupcakeServiceTest {

    @InjectMocks
    private CupcakeService service;

    @Mock
    private CupcakeRepository repository;

    @Test
    void testGetCupcakes() {
        when(repository.findAll(any(Pageable.class))).thenReturn(Page.empty());

        assertDoesNotThrow(() -> service.getCupcakes(Pageable.ofSize(1)));
    }

    @Test
    void testSaveCupcake() {
        when(repository.save(any(CupcakeEntity.class))).thenReturn(CupcakeBuild.getEntity(false, true));

        CupcakeForm form = CupcakeBuild.getForm(true);

        assertDoesNotThrow(() -> service.saveCupcake(form));
    }

    @Test
    void testDeleteCupcake() {
        when(repository.findById(any(UUID.class))).thenReturn(Optional.of(CupcakeBuild.getEntity(false, true)));
        doNothing().when(repository).deleteById(any(UUID.class));

        assertDoesNotThrow(() -> service.deleteCupcake(UUID.randomUUID().toString()));
    }

    @Test
    void testDeleteCupcakeNotFoundId() {
        when(repository.findById(any(UUID.class))).thenThrow(new EntityNotFoundException());

        assertThrows(EntityNotFoundException.class, () -> service.deleteCupcake(UUID.randomUUID().toString()));
    }

    @Test
    void testDisableCupcake() {
        when(repository.findById(any(UUID.class))).thenReturn(Optional.of(CupcakeBuild.getEntity(false, true)));
        when(repository.save(any(CupcakeEntity.class))).thenReturn(CupcakeBuild.getEntity(true, true));

        assertDoesNotThrow(() -> service.disableCupcake(UUID.randomUUID().toString()));
    }

    @Test
    void testDisableCupcakeNotFoundId() {
        when(repository.findById(any(UUID.class))).thenThrow(new EntityNotFoundException());

        assertThrows(EntityNotFoundException.class, () -> service.disableCupcake(UUID.randomUUID().toString()));
    }

}
