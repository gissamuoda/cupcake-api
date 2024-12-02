package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.ClienteDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.ClienteForm;
import com.gissamusworkspace.cupcakeapi.services.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupcake-api/v1/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO saveCliente(@RequestBody @Valid final ClienteForm form) {
        return service.saveCliente(form);
    }

}
