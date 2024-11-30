package com.gissamusworkspace.cupcakeapi.repositories;

import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

}
