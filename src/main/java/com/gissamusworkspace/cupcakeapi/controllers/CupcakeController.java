package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.services.CupcakeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupcake-api/v1/cupcake")
@RequiredArgsConstructor
public class CupcakeController {

    private final CupcakeService cupcakeService;

    @GetMapping
    public Page<CupcakeDTO> getCupcakes() {
        return cupcakeService.getCupcakes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CupcakeDTO saveCupcake(@RequestBody @Valid final CupcakeForm cupcakeForm) {
        return cupcakeService.saveCupcake(cupcakeForm);
    }

}
