package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.EnderecoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.EnderecoEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.EnderecoForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.EnderecoBuild;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnderecoEntityMapperTest {

    private static final EnderecoEntityMapper mapper = EnderecoEntityMapper.instance;

    private EnderecoForm form = EnderecoBuild.getForm();

    private EnderecoEntity entity = EnderecoBuild.getEntity();

    @Test
    void testMapEntity() {
        EnderecoEntity mapped = mapper.mapEntity(form);

        assertEquals(form.getCidade(), mapped.getCidade());
        assertEquals(form.getRua(), mapped.getRua());
        assertEquals(form.getBairro(), mapped.getBairro());
        assertEquals(form.getNumeroCasa(), mapped.getNumeroCasa());
        assertEquals(form.getComplemento(), mapped.getComplemento());
    }

    @Test
    void testMapDto() {
        EnderecoDTO mapped = mapper.mapDto(entity);

        assertEquals(entity.getId(), mapped.getId());
        assertEquals(entity.getCidade(), mapped.getCidade());
        assertEquals(entity.getRua(), mapped.getRua());
        assertEquals(entity.getBairro(), mapped.getBairro());
        assertEquals(entity.getNumeroCasa(), mapped.getNumeroCasa());
        assertEquals(entity.getComplemento(), mapped.getComplemento());
    }

}
