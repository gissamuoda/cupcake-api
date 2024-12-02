package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ClienteDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.ClienteForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.ClienteBuild;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteEntityMapperTest {

    private static final ClienteEntityMapper mapper = ClienteEntityMapper.instance;

    private final ClienteForm form = ClienteBuild.getForm();

    private final ClienteEntity entity = ClienteBuild.getEntity();

    @Test
    void testMapEntity() {
        ClienteEntity mapped = mapper.mapEntity(form);

        assertEquals(entity.getNome(), mapped.getNome());
        assertEquals(entity.getEmail(), mapped.getEmail());
        assertEquals(entity.getSenha(), mapped.getSenha());
        assertEquals(entity.getTelephone(), mapped.getTelephone());
        assertEquals(entity.getEnderecos().size(), mapped.getEnderecos().size());
    }

    @Test
    void testMapDto() {
        ClienteDTO mapped = mapper.mapDto(entity);

        assertEquals(entity.getId(), mapped.getId());
        assertEquals(entity.getNome(), mapped.getNome());
        assertEquals(entity.getEmail(), mapped.getEmail());
        assertEquals(entity.getTelephone(), mapped.getTelephone());
        assertEquals(entity.getEnderecos().size(), mapped.getEnderecos().size());
    }

}
