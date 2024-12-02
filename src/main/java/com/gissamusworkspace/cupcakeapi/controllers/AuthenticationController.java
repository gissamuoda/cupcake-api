package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.LoginTokenDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.LoginForm;
import com.gissamusworkspace.cupcakeapi.services.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupcake-api/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken token  = new UsernamePasswordAuthenticationToken(form.getEmail(), form.getSenha());
        Authentication authenticate = manager.authenticate(token);
        String tokenJWT = tokenService.generateToken((UserDetails) authenticate.getPrincipal());
        return ResponseEntity.ok(new LoginTokenDTO(tokenJWT));
    }

}
