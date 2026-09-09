package com.senai.backend.equipamentos.configs;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@Configuration
@OpenAPIDefinition(
info = @Info(
title = "API de controle de equipamentos",
version = "1.0",
description = "API para gerenciamento de equipamentos, incluindo cadastro, listagem e exclusão de usuários."
)
)
public class Swagger {
    
}
