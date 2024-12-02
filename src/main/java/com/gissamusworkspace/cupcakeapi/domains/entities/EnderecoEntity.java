package com.gissamusworkspace.cupcakeapi.domains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "endereco")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cidade;

    private String rua;

    private String bairro;

    private String numeroCasa;

    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

}
