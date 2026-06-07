# Fintech Microservices

Projeto de estudo desenvolvido para aprofundar conhecimentos em arquitetura de microserviços utilizando Java e Spring Boot.

O objetivo deste projeto é simular uma plataforma fintech composta por múltiplos serviços independentes que se comunicam entre si, aplicando conceitos utilizados no mercado de tecnologia.

## Objetivos

- Aprender arquitetura de microserviços
- Aplicar boas práticas de desenvolvimento backend
- Explorar comunicação síncrona e assíncrona entre serviços
- Implementar autenticação e autorização
- Utilizar mensageria para integração entre sistemas
- Praticar conteinerização e deploy de aplicações

## Arquitetura

Atualmente o projeto está sendo desenvolvido com os seguintes componentes:

- ms-clientes
- ms-cartoes
- ms-avaliador-credito
- gateway
- eureka-server

Componentes planejados:

- Keycloak (Autenticação e Autorização)
- RabbitMQ (Mensageria)
- Docker
- Observabilidade
- Deploy em nuvem

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Cloud
- Spring Data JPA
- Eureka Server
- Spring Cloud Gateway
- RabbitMQ
- Keycloak
- Docker
- Maven

## Estrutura do Projeto

```text
fintech-microservices/
├── msclientes
├── mscartoes
├── msavaliadorcredito
├── gateway
├── eureka-server
└── docs