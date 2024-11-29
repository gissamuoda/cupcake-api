package com.gissamusworkspace.cupcakeapi.repositories;

import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CupcakeRepository extends JpaRepository<CupcakeEntity, UUID> {

}
