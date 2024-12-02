package com.gissamusworkspace.cupcakeapi.domains.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

import static com.gissamusworkspace.cupcakeapi.domains.constants.RoleConstants.ROLE_ADMIN;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdminEntity extends ClienteEntity {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ROLE_ADMIN));
    }

}
