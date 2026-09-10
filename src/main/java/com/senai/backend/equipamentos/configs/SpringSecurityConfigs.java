package com.senai.backend.equipamentos.configs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigs {

        private static final String SECRET =
            "EXC2jdWOrQ2Z8O04jzDAaekH75NVsHUOIl0354oyh2U=";

    private final SecretKey chave =
            Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8)
            );

    private static final long TEMPO_EXPIRACAO = 86400000;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        

        httpSecurity
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                    "/usuarios/login",
                    "/usuarios/cadastrar-usuario",

                    "/controle-equipamentos/swagger-ui/**",
                    "/controle-equipamentos/v3/api-docs/**",

                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                ).permitAll()

                .anyRequest().authenticated()
                
            )
            .addFilterBefore(
    jwtFilter(),
    UsernamePasswordAuthenticationFilter.class
);

        return httpSecurity.build();
    }

    // GERAR TOKEN
    public String gerarToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                    new Date(
                        System.currentTimeMillis()
                        + TEMPO_EXPIRACAO
                    )
                )
                .signWith(chave)
                .compact();
    }

    // VALIDAR TOKEN
    public boolean validarToken(String token) {

        try {

            Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // PEGAR EMAIL
    public String pegarEmail(String token) {

        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // FILTRO JWT
    @Bean
    public OncePerRequestFilter jwtFilter() {

        return new OncePerRequestFilter() {

            @Override
            protected void doFilterInternal(
                    HttpServletRequest request,
                    HttpServletResponse response,
                    FilterChain filterChain
            ) throws ServletException, IOException {

                String header =
                        request.getHeader("Authorization");

                if (header != null &&
                    header.startsWith("Bearer ")) {

                    String token =
                            header.substring(7);

                    if (validarToken(token)) {

                        String email =
                                pegarEmail(token);

                        UsernamePasswordAuthenticationToken auth =
                                new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                java.util.Collections.emptyList()
                            );

                        SecurityContextHolder
                            .getContext()
                            .setAuthentication(auth);
                    }
                }

                filterChain.doFilter(
                    request,
                    response
                );
            }
        };
    }
}
