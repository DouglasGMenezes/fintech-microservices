# PROJECT_CONTEXT.md

## Contexto

Este projeto é um estudo prático de arquitetura de microserviços desenvolvido por um desenvolvedor Backend Java Júnior com objetivo de:

* Aprender arquitetura de microserviços.
* Evoluir tecnicamente como desenvolvedor Java.
* Construir um projeto de portfólio para GitHub e LinkedIn.
* Aplicar conceitos utilizados em ambientes corporativos reais.

O projeto está sendo desenvolvido acompanhando um curso online, porém diversas adaptações estão sendo realizadas para utilizar versões mais recentes das tecnologias.

---

# Papel da IA

Ao atuar neste projeto:

* Não assumir que a solução mais complexa é a melhor.
* Priorizar simplicidade e clareza.
* Explicar conceitos quando necessário.
* Justificar decisões arquiteturais.
* Evitar overengineering.
* Considerar que o desenvolvedor é nível Júnior.
* Quando possível, sugerir boas práticas utilizadas no mercado.

---

# Estrutura do Projeto

Monorepo:

```text
fintech-microservices/
├── msclientes
├── mscartoes
├── msavaliadorcredito
├── mscloudgateway
├── eurekaserver
└── README.md
```

Todos os microsserviços estão no mesmo repositório Git.

---

# Tecnologias

## Linguagem

* Java 21

## Framework

* Spring Boot

## Arquitetura

* Microservices
* API Gateway
* Service Discovery

## Componentes Planejados

* Eureka Server
* Eureka Client
* Spring Cloud Gateway
* RabbitMQ
* Keycloak
* Docker
* Swagger/OpenAPI
* Observabilidade
* Deploy em Cloud

---

# Microsserviços

## msclientes

Responsabilidades:

* Cadastro de clientes
* Consulta de clientes
* Atualização de dados

Possíveis evoluções:

* ViaCEP
* Data de nascimento
* Cálculo automático de idade

---

## mscartoes

Responsabilidades:

* Gestão de cartões
* Emissão de cartões
* Associação cliente/cartão

---

## msavaliadorcredito

Responsabilidades:

* Avaliação de crédito
* Regras de aprovação
* Integração entre serviços

---

## mscloudgateway

Responsabilidades:

* API Gateway
* Roteamento
* Entrada única da plataforma

Tecnologia:

* Spring Cloud Gateway
* WebFlux

---

## eurekaserver

Responsabilidades:

* Service Discovery
* Registro de serviços

Tecnologia:

* Netflix Eureka

---

# Convenções

## DTOs

Utilizar Java Records sempre que possível.

Exemplo:

```java
public record ClienteSaveRequestDTO(
    String cpf,
    String nome,
    Integer idade
) {}
```

---

## Mapper

Utilizar classes Mapper dedicadas.

Exemplo:

```java
ClienteMapper.toEntity(...)
ClienteMapper.toResponseDTO(...)
```

---

## Repositories

Utilizar Spring Data JPA.

Exemplo:

```java
Optional<Cliente> findByCpf(String cpf);
```

---

## Optional

Preferir Optional para consultas que podem não retornar resultado.

Evitar retornar null.

---

## Validações

Priorizar soluções simples.

Não utilizar abstrações complexas sem necessidade.

Preferir:

```java
if (...) {
   ...
}
```

ao invés de estratégias excessivamente genéricas quando o ganho for pequeno.

---

# Filosofia de Desenvolvimento

Prioridades:

1. Aprender conceitos.
2. Entender o funcionamento.
3. Produzir código legível.
4. Aplicar boas práticas.
5. Evoluir a arquitetura gradualmente.

Evitar:

* Overengineering.
* Patterns desnecessários.
* Abstrações prematuras.
* Complexidade sem ganho real.

---

# Objetivo Final

Construir uma plataforma fintech baseada em microserviços contendo:

* Cadastro de clientes
* Gestão de cartões
* Avaliação de crédito
* Service Discovery
* API Gateway
* Mensageria
* Segurança
* Containerização
* Deploy em nuvem

que possa ser utilizada como projeto de portfólio profissional.
