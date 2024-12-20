package com.gissamusworkspace.cupcakeapi.domains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "cupcake")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CupcakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String sabor;

    private List<String> ingredientes;

    private Boolean disabled;

}
