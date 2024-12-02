package com.gissamusworkspace.cupcakeapi.infrastructure;

import com.gissamusworkspace.cupcakeapi.domains.dtos.EnderecoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.EnderecoEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.EnderecoForm;

import java.util.UUID;

public class EnderecoBuild {

    public static EnderecoEntity getEntity() {
        EnderecoEntity entity = new EnderecoEntity();
        entity.setId(UUID.randomUUID());
        entity.setCidade("cidade");
        entity.setRua("rua");
        entity.setBairro("bairro");
        entity.setNumeroCasa("1");
        entity.setComplemento("complemento");

        return entity;
    }

    public static EnderecoForm getForm() {
        EnderecoForm form = new EnderecoForm();
        form.setCidade("cidade");
        form.setRua("rua");
        form.setBairro("bairro");
        form.setNumeroCasa("1");
        form.setComplemento("complemento");

        return form;
    }

    public static EnderecoDTO getDto() {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(UUID.randomUUID());
        dto.setCidade("cidade");
        dto.setRua("rua");
        dto.setBairro("bairro");
        dto.setNumeroCasa("1");
        dto.setComplemento("complemento");

        return dto;
    }
}
