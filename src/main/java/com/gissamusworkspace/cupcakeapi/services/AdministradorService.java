package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.dtos.AdministradorDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.AdminEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.AdministradorForm;
import com.gissamusworkspace.cupcakeapi.mappers.AdminEntityMapper;
import com.gissamusworkspace.cupcakeapi.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministradorService {

    private static final AdminEntityMapper mapper = AdminEntityMapper.instance;

    private final ClienteRepository repository;

    public AdministradorDTO saveAdministrador(final AdministradorForm form) {
        form.setSenha(encryptSenha(form.getSenha()));

        AdminEntity entity = mapper.mapEntity(form);

        repository.save(entity);

        return mapper.mapDto(entity);
    }

    private String encryptSenha(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
