package com.gissamusworkspace.cupcakeapi.infrastructure;

import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.ClienteForm;

import java.util.List;
import java.util.UUID;

public class ClienteBuild {

    public static ClienteForm getForm() {
        ClienteForm form = new ClienteForm();
        form.setNome("nome");
        form.setEmail("email");
        form.setSenha("senha");
        form.setTelephone("telephone");
        form.setEnderecos(List.of(EnderecoBuild.getForm()));

        return form;
    }

    public static ClienteEntity getEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(UUID.randomUUID());
        entity.setNome("nome");
        entity.setEmail("email");
        entity.setSenha("senha");
        entity.setTelephone("telephone");
        entity.setEnderecos(List.of(EnderecoBuild.getEntity()));

        entity.getEnderecos().forEach(endereco -> {
            endereco.setCliente(entity);
        });

        return entity;
    }
}
