package com.gissamusworkspace.cupcakeapi.domains.dtos;

import com.gissamusworkspace.cupcakeapi.domains.enums.StatusPedido;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoEntrega;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private UUID id;

    private Map<CupcakeDTO, Integer> cupcakes;

    private TipoPagamento tipoPagamento;

    private TipoEntrega tipoEntrega;

    private StatusPedido statusPedido;

    private LocalDateTime dataHoraCriacaoPedido;

}
