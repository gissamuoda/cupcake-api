package com.gissamusworkspace.cupcakeapi.infrastructure;

import com.gissamusworkspace.cupcakeapi.domains.entities.AdminEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.AdministradorForm;

import java.util.UUID;

public class AdministradorBuild {

    public static AdministradorForm getForm() {
        AdministradorForm form = new AdministradorForm();
        form.setNome("nome");
        form.setEmail("email");
        form.setSenha("senha");
        form.setTelephone("telephone");

        return form;
    }

    public static AdminEntity getEntity() {
        AdminEntity entity = new AdminEntity();
        entity.setId(UUID.randomUUID());
        entity.setNome("nome");
        entity.setEmail("email");
        entity.setSenha("senha");
        entity.setTelephone("telephone");
        entity.setEnderecos(null);
        entity.setAdministrador(true);

        return entity;
    }
}
