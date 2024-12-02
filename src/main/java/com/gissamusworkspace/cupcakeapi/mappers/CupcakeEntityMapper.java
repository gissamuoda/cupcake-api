package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CupcakeEntityMapper {

    CupcakeEntityMapper instance = Mappers.getMapper(CupcakeEntityMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "sabor", source = "sabor")
    @Mapping(target = "ingredientes", source = "ingredientes")
    @Mapping(target = "disabled", constant = "false")
    CupcakeEntity mapEntity(final CupcakeForm form);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "sabor", source = "sabor")
    @Mapping(target = "ingredientes", source = "ingredientes")
    @Mapping(target = "disabled", source = "disabled")
    CupcakeDTO mapDTO(final CupcakeEntity entity);

}
