package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.AdministradorDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.AdminEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.AdministradorForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.AdministradorBuild;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdminEntityMapperTest {

    private static final AdminEntityMapper mapper = AdminEntityMapper.instance;

    private final AdministradorForm form = AdministradorBuild.getForm();

    private final AdminEntity entity = AdministradorBuild.getEntity();

    @Test
    void testMapEntity() {
        AdminEntity mapped = mapper.mapEntity(form);

        assertNull(mapped.getId());
        assertEquals(form.getNome(), mapped.getNome());
        assertEquals(form.getEmail(), mapped.getEmail());
        assertEquals(form.getSenha(), mapped.getSenha());
        assertEquals(form.getTelephone(), mapped.getTelephone());
        assertTrue(mapped.getAdministrador());
    }

    @Test
    void testMapDto() {
        AdministradorDTO mapped = mapper.mapDto(entity);

        assertEquals(entity.getId(), mapped.getId());
        assertEquals(entity.getNome(), mapped.getNome());
        assertEquals(entity.getEmail(), mapped.getEmail());
        assertEquals(form.getTelephone(), mapped.getTelephone());
    }

}
