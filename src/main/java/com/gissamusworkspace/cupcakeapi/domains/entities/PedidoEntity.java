package com.gissamusworkspace.cupcakeapi.domains.entities;

import com.gissamusworkspace.cupcakeapi.domains.enums.StatusPedido;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoEntrega;
import com.gissamusworkspace.cupcakeapi.domains.enums.TipoPagamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "pedido")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<PedidoCupcakeEntity> cupcakes = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.ORDINAL)
    private TipoEntrega tipoEntrega;

    @Enumerated(EnumType.ORDINAL)
    private StatusPedido statusPedido;

    private LocalDateTime dataHoraCriacaoPedido;

}
