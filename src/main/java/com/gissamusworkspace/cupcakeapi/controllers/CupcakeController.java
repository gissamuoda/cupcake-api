package com.gissamusworkspace.cupcakeapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cupcake")
@RequiredArgsConstructor
public class CupcakeController {


    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String testEndpoint() {
        return "Endpoint funcional running";
    }

}
