package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.PedidoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoEntity;
import com.gissamusworkspace.cupcakeapi.domains.enums.StatusPedido;
import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import com.gissamusworkspace.cupcakeapi.infrastructure.PedidoBuild;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PedidoEntityMapperTest {

    private static final PedidoEntityMapper mapper = PedidoEntityMapper.instance;

    @Test
    void testMapEntity() {
        PedidoForm form = PedidoBuild.getForm();

        PedidoEntity pedidoEntity = mapper.mapEntity(form);

        assertEquals(form.getTipoEntrega(), pedidoEntity.getTipoEntrega().getIndex());
        assertEquals(form.getTipoPagamento(), pedidoEntity.getTipoPagamento().getIndex());
        assertEquals(StatusPedido.REALIZADO, pedidoEntity.getStatusPedido());
        assertNotNull(pedidoEntity.getDataHoraCriacaoPedido());
    }

    @Test
    void testMapDto() {
        PedidoEntity entity = PedidoBuild.getEntity();

        PedidoDTO dto = mapper.mapDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getTipoEntrega(), dto.getTipoEntrega());
        assertEquals(entity.getTipoPagamento(), dto.getTipoPagamento());
        assertEquals(entity.getStatusPedido(), dto.getStatusPedido());
        assertEquals(entity.getDataHoraCriacaoPedido(), dto.getDataHoraCriacaoPedido());
        assertNotNull(dto.getCupcakes());
    }

}