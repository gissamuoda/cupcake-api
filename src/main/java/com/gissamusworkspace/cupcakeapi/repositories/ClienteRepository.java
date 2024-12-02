package com.gissamusworkspace.cupcakeapi.repositories;

import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    UserDetails findByEmail(String email);

}
