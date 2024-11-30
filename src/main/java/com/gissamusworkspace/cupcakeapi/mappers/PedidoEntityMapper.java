package com.gissamusworkspace.cupcakeapi.mappers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.PedidoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoEntity;
import com.gissamusworkspace.cupcakeapi.domains.enums.StatusPedido;
import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface PedidoEntityMapper {

    PedidoEntityMapper instance = Mappers.getMapper(PedidoEntityMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoPagamento", source = "tipoPagamento")
    @Mapping(target = "tipoEntrega", source = "tipoEntrega")
    @Mapping(target = "statusPedido", ignore = true)
    @Mapping(target = "dataHoraCriacaoPedido", ignore = true)
    PedidoEntity mapEntity(PedidoForm form);

    @AfterMapping
    default void afterMappingEntity(@MappingTarget PedidoEntity entity, PedidoForm form) {
        entity.setStatusPedido(StatusPedido.REALIZADO);
        entity.setDataHoraCriacaoPedido(LocalDateTime.now());
    }

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cupcakes", ignore = true)
    @Mapping(target = "tipoPagamento", source = "tipoPagamento")
    @Mapping(target = "tipoEntrega", source = "tipoEntrega")
    @Mapping(target = "statusPedido", source = "statusPedido")
    @Mapping(target = "dataHoraCriacaoPedido", source = "dataHoraCriacaoPedido")
    PedidoDTO mapDto(PedidoEntity entity);

    @AfterMapping
    default void afterMappingDto(@MappingTarget PedidoDTO dto, PedidoEntity entity) {
        entity.getCupcakes().forEach(pedidoCupcakeEntity -> {
            dto.getCupcakes().put(CupcakeEntityMapper.instance.mapDTO(pedidoCupcakeEntity.getCupcake()).getNome(),pedidoCupcakeEntity.getQuantity());
        });
    }

}
