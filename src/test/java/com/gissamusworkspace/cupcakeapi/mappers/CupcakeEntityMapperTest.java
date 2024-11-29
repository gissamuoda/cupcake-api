package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.CupcakeBuild;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class CupcakeEntityMapperTest {

    private final static CupcakeEntityMapper mapper = CupcakeEntityMapper.instance;

    @Test
    void testSuccessMapFormToEntity() {
        final CupcakeForm form = CupcakeBuild.getForm(true);

        final CupcakeEntity entity = mapper.mapEntity(form);

        assertEquals(entity.getNome(), form.getNome());
        assertEquals(entity.getSabor(), form.getSabor());
        assertIngredientes(entity.getIngredientes(), form.getIngredientes());
        assertFalse(entity.getDisabled());
    }

    @Test
    void testSuccessMapFormToEntityWithoutList() {
        final CupcakeForm form = CupcakeBuild.getForm(false);

        final CupcakeEntity entity = mapper.mapEntity(form);

        assertEquals(entity.getNome(), form.getNome());
        assertEquals(entity.getSabor(), form.getSabor());
        assertNull(entity.getIngredientes());
        assertFalse(entity.getDisabled());
    }

    @Test
    void testSuccessMapFormToEntityNull() {
        final CupcakeEntity entity = mapper.mapEntity(null);

        assertNull(entity);
    }

    @Test
    void testSuccessMapEntityToDto() {
        final CupcakeEntity entity = CupcakeBuild.getEntity(true);
        final CupcakeDTO dto = mapper.mapDTO(entity);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getNome(), entity.getNome());
        assertEquals(dto.getSabor(), entity.getSabor());
        assertIngredientes(dto.getIngredientes(), entity.getIngredientes());
        assertEquals(dto.getDisabled(), entity.getDisabled());
    }

    @Test
    void testSuccessMapEntityToDtoWithoutList() {
        final CupcakeEntity entity = CupcakeBuild.getEntity(false);
        final CupcakeDTO dto = mapper.mapDTO(entity);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getNome(), entity.getNome());
        assertEquals(dto.getSabor(), entity.getSabor());
        assertNull(dto.getIngredientes());
        assertEquals(dto.getDisabled(), entity.getDisabled());
    }

    @Test
    void testSuccessMapEntityToDtoNull() {
        final CupcakeDTO dto = mapper.mapDTO(null);

        assertNull(dto);
    }

    private void assertIngredientes(List<String> expected, List<String> actual) {
        for(int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
