package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ClienteDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.ClienteEntity;
import com.gissamusworkspace.cupcakeapi.domains.forms.ClienteForm;
import com.gissamusworkspace.cupcakeapi.mappers.ClienteEntityMapper;
import com.gissamusworkspace.cupcakeapi.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private static final ClienteEntityMapper mapper = ClienteEntityMapper.instance;

    private final ClienteRepository repository;

    public ClienteDTO saveCliente(final ClienteForm clienteForm) {
        clienteForm.setSenha(encryptSenha(clienteForm.getSenha()));

        ClienteEntity clienteEntity = mapper.mapEntity(clienteForm);

        repository.save(clienteEntity);

        return mapper.mapDto(clienteEntity);
    }

    public UserDetails getClienteEntityForLogin(final String email) {
        return repository.findByEmail(email);
    }

    private String encryptSenha(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
