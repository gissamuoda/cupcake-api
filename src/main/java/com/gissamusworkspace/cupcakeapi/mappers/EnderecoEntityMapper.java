package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.EnderecoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.EnderecoEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.EnderecoForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoEntityMapper {

    EnderecoEntityMapper instance = Mappers.getMapper(EnderecoEntityMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cidade", source = "cidade")
    @Mapping(target = "rua", source = "rua")
    @Mapping(target = "bairro", source = "bairro")
    @Mapping(target = "numeroCasa", source = "numeroCasa")
    @Mapping(target = "complemento", source = "complemento")
    @Mapping(target = "cliente", ignore = true)
    EnderecoEntity mapEntity(EnderecoForm form);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cidade", source = "cidade")
    @Mapping(target = "rua", source = "rua")
    @Mapping(target = "bairro", source = "bairro")
    @Mapping(target = "numeroCasa", source = "numeroCasa")
    @Mapping(target = "complemento", source = "complemento")
    EnderecoDTO mapDto(EnderecoEntity entity);

}
