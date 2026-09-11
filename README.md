# API de Controle de Equipamentos

Projeto desenvolvido em Java com Spring Boot para gerenciamento de equipamentos, usuários e movimentações de estoque.

## Funcionalidades

- Cadastro, listagem, edição e exclusão de usuários
- Cadastro, listagem, edição e exclusão de equipamentos
- Login com autenticação JWT
- Proteção de rotas com Spring Security
- Entrada e saída de equipamentos do estoque
- Histórico de movimentações
- Consulta de equipamentos com estoque mínimo
- Documentação e testes da API com Swagger

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Swagger / OpenAPI
- Maven

## Estrutura do projeto

- `models` - entidades da aplicação
- `repositories` - comunicação com o banco de dados
- `services` - regras de negócio
- `controllers` - rotas e requisições da API
- `configs` - configurações de segurança e Swagger

## Banco de dados

O projeto utiliza PostgreSQL para armazenar usuários, equipamentos e movimentações.
