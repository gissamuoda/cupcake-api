package com.gissamusworkspace.cupcakeapi.infrastructure;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;

import java.util.List;
import java.util.UUID;

public class CupcakeBuild {

    public static CupcakeForm getForm(final boolean withLists) {
        CupcakeForm form = new CupcakeForm();
        form.setNome("cupcake test");
        form.setSabor("test");
        form.setIngredientes(getIngredientesList(withLists));

        return form;
    }

    public static CupcakeDTO getDto(final boolean withLists) {
        CupcakeDTO dto = new CupcakeDTO();
        dto.setId(UUID.randomUUID());
        dto.setNome("cupcake test");
        dto.setSabor("test");
        dto.setIngredientes(getIngredientesList(withLists));
        dto.setDisabled(false);

        return dto;
    }

    public static CupcakeEntity getEntity(final boolean withLists) {
        CupcakeEntity entity = new CupcakeEntity();
        entity.setId(UUID.randomUUID());
        entity.setNome("cupcake test");
        entity.setSabor("test");
        entity.setIngredientes(getIngredientesList(withLists));
        entity.setDisabled(false);

        return entity;
    }

    private static List<String> getIngredientesList(final boolean withLists) {
        return withLists ? List.of("ingrediente teste 1", "ingrediente teste 2", "ingrediente teste 3") : null;
    }
}
