package com.gissamusworkspace.cupcakeapi.repositories;

import com.gissamusworkspace.cupcakeapi.domains.entities.CupcakeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CupcakeRepository extends JpaRepository<CupcakeEntity, UUID> {

    Page<CupcakeEntity> findAllByDisabled(Pageable pageable, final Boolean disabled);

}
