package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.mappers.CupcakeEntityMapper;
import com.gissamusworkspace.cupcakeapi.repositories.CupcakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CupcakeService {

    private static final CupcakeEntityMapper mapper = CupcakeEntityMapper.instance;

    private final CupcakeRepository repository;

    public Page<CupcakeDTO> getCupcakes(final Pageable page) {
        return repository.findAll(page).map(mapper::mapDTO);
    }

    public CupcakeDTO saveCupcake(final CupcakeForm form) {
        final CupcakeEntity entity = mapper.mapEntity(form);

        repository.save(entity);

        return mapper.mapDTO(entity);
    }

    public void deleteCupcake(final String cupcakeId) {
        getCupcakeById(UUID.fromString(cupcakeId));

        repository.deleteById(UUID.fromString(cupcakeId));
    }

    public CupcakeDTO disableCupcake(final String cupcakeId) {
        final CupcakeEntity cupcakeToDisable = getCupcakeById(UUID.fromString(cupcakeId));
        cupcakeToDisable.setDisabled(true);

        final CupcakeEntity updatedCupcake = repository.save(cupcakeToDisable);

        return mapper.mapDTO(updatedCupcake);
    }

    public CupcakeEntity getCupcakeById(final UUID cupcakeId) {
        return repository.findById(cupcakeId).orElseThrow();
    }

}
