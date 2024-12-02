package com.gissamusworkspace.cupcakeapi.configurations.security;

import com.gissamusworkspace.cupcakeapi.controllers.filters.SecurityFilter;
import com.gissamusworkspace.cupcakeapi.domains.constants.RoleConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final SecurityFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/cupcake-api/login").permitAll();
                    request.requestMatchers(HttpMethod.POST, "/cupcake-api/v1/cliente").permitAll();
                    request.requestMatchers(HttpMethod.GET, "/cupcake-api/v1/cupcake").permitAll();
                    request.requestMatchers(HttpMethod.POST, "/cupcake-api/v1/admin").hasRole(RoleConstants.ROLE_ADMIN);
                    request.requestMatchers(HttpMethod.PUT, "/cupcake-api/v1/*").hasRole(RoleConstants.ROLE_ADMIN);
                    request.requestMatchers(HttpMethod.DELETE, "/cupcake-api/v1/*").hasRole(RoleConstants.ROLE_ADMIN);
                    request.requestMatchers(HttpMethod.POST, "/cupcake-api/v1/cup").hasRole(RoleConstants.ROLE_ADMIN); //todo: understand why only that way de authentication work
                    request.anyRequest().authenticated();
                })
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
