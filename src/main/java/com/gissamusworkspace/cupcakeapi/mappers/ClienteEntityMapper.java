package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ClienteDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.ClienteForm;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        EnderecoEntityMapper.class
})
public interface ClienteEntityMapper {

    ClienteEntityMapper instance = Mappers.getMapper(ClienteEntityMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "enderecos", source = "enderecos")
    @Mapping(target = "administrador", constant = "false")
    ClienteEntity mapEntity(ClienteForm form);

    @AfterMapping
    default void afterMappingEntity(@MappingTarget ClienteEntity entity, ClienteForm form) {
        entity.getEnderecos().forEach(enderecoEntity -> {
            enderecoEntity.setCliente(entity);
        });
    }

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "enderecos", source = "enderecos")
    ClienteDTO mapDto(ClienteEntity entity);


}
