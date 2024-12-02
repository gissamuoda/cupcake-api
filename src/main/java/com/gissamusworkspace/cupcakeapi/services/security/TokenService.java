package com.gissamusworkspace.cupcakeapi.services.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final String secret;

    private final String issuer;

    public TokenService(@Value("${cupcakeapi.security.token.secret}") String secret, @Value("${cupcakeapi.security.token.issuer}") String issuer) {
        this.secret = secret;
        this.issuer = issuer;
    }

    public String generateToken(UserDetails userDetails) {
        try {
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(userDetails.getUsername())
                    .withExpiresAt(getExpiresAt())
                    .sign(getAlgorithm());
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            return JWT.require(getAlgorithm())
                    .withIssuer(issuer)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido ou expirado", exception);
        }
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    private Instant getExpiresAt() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
