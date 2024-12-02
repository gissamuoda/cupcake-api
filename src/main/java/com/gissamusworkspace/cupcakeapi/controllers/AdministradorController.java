package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.AdministradorDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.AdministradorForm;
import com.gissamusworkspace.cupcakeapi.services.AdministradorService;
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
@RequestMapping("/cupcake-api/v1/administrador")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService service;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public AdministradorDTO saveCliente(@RequestBody @Valid final AdministradorForm form) {
        return service.saveAdministrador(form);
    }


}
