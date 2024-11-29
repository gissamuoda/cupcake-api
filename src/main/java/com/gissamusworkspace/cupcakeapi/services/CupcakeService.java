package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.mappers.CupcakeEntityMapper;
import com.gissamusworkspace.cupcakeapi.repositories.CupcakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CupcakeService {

    private static final CupcakeEntityMapper mapper = CupcakeEntityMapper.instance;

    private final CupcakeRepository repository;

    public Page<CupcakeDTO> getCupcakes() {
        return Page.empty();
    }

    public CupcakeDTO saveCupcake(final CupcakeForm form) {
        CupcakeEntity entity = mapper.mapEntity(form);

        return mapper.mapDTO(entity);
    }

}
