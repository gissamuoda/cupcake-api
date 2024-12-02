package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.AdministradorDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.AdminEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.AdministradorForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminEntityMapper {

    AdminEntityMapper instance = Mappers.getMapper(AdminEntityMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "administrador", constant = "true")
    AdminEntity mapEntity(AdministradorForm form);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telephone", source = "telephone")
    AdministradorDTO mapDto(AdminEntity entity);

}
