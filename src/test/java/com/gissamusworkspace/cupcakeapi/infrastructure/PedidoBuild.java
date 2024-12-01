package com.gissamusworkspace.cupcakeapi.infrastructure;

import com.gissamusworkspace.cupcakeapi.domains.dtos.PedidoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoCupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoEntity;
import com.gissamusworkspace.cupcakeapi.domains.enums.StatusPedido;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoEntrega;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoPagamento;
import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PedidoBuild {

    public static PedidoForm getForm() {
        PedidoForm form = new PedidoForm();
        form.setTipoPagamento(1);
        form.setTipoEntrega(1);
        form.setCupcakesIds(getCupcakeIdsMap());

        return form;
    }

    public static PedidoEntity getEntity() {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(UUID.randomUUID());
        entity.setTipoEntrega(TipoEntrega.RETIRAR_NA_LOJA);
        entity.setTipoPagamento(TipoPagamento.NO_LOCAL);
        entity.setStatusPedido(StatusPedido.REALIZADO);
        entity.setDataHoraCriacaoPedido(LocalDateTime.now());
        entity.setCupcakes(getPedidoCupcakeList());

        entity.getCupcakes().forEach(cupcake -> {
           cupcake.setPedido(entity);
        });

        return entity;
    }

    public static PedidoDTO getDto() {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(UUID.randomUUID());
        dto.setStatusPedido(StatusPedido.REALIZADO);
        dto.setTipoEntrega(TipoEntrega.RETIRAR_NA_LOJA);
        dto.setTipoPagamento(TipoPagamento.NO_LOCAL);
        dto.setDataHoraCriacaoPedido(LocalDateTime.now());
        dto.setCupcakes(getCupcakeDtoMap());

        return dto;
    }

    private static Map<String, Integer> getCupcakeIdsMap() {
        return Map.of(UUID.randomUUID().toString(), 2, UUID.randomUUID().toString(), 1);
    }

    private static List<PedidoCupcakeEntity> getPedidoCupcakeList() {
        return List.of(getPedidoCupcake(1), getPedidoCupcake(2));
    }

    private static PedidoCupcakeEntity getPedidoCupcake(final Integer id) {
        PedidoCupcakeEntity pedidoCupcakeEntity = new PedidoCupcakeEntity();
        pedidoCupcakeEntity.setId(id);
        pedidoCupcakeEntity.setCupcake(CupcakeBuild.getEntity(false, true));
        pedidoCupcakeEntity.setQuantity(1);

        return pedidoCupcakeEntity;
    }

    private static Map<String, Integer> getCupcakeDtoMap() {
        HashMap<String, Integer> cupcakeMap = new HashMap<>();
        cupcakeMap.put(CupcakeBuild.getDto(false).getNome(), 2);
        cupcakeMap.put(CupcakeBuild.getDto(false).getNome(), 1);

        return cupcakeMap;
    }
}
