# Repository Guidelines

## Project Structure & Module Organization

This repository contains a Spring Boot Cloud Gateway service using WebFlux and Eureka discovery. Main Java code lives under `src/main/java/br/com/dgm/mscloudgateway`, with `MscloudgatewayApplication.java` as the application entry point. Runtime configuration is in `src/main/resources/application.yaml`, including the service name, gateway discovery locator, port `8080`, and Eureka endpoint. Tests mirror the main package under `src/test/java/br/com/dgm/mscloudgateway`. Maven build output is generated in `target/` and should not be edited manually.

## Build, Test, and Development Commands

Use the Maven wrapper so contributors run the same Maven version:

```sh
./mvnw clean package
```

Builds the project and runs tests.

```sh
./mvnw test
```

Runs the JUnit test suite only.

```sh
./mvnw spring-boot:run
```

Starts the gateway locally on port `8080`. For service discovery to work, ensure the Eureka server is available at `http://localhost:8761/eureka` or override `eureka.client.service-url.defaultZone`.

## Coding Style & Naming Conventions

Use Java 21 and the existing Spring Boot conventions. Keep packages under `br.com.dgm.mscloudgateway`. Use 4-space indentation for Java code, descriptive class names in `PascalCase`, method and field names in `camelCase`, and constants in `UPPER_SNAKE_CASE`. Prefer constructor injection for Spring components when adding beans. Keep YAML keys lowercase and nested consistently with Spring configuration names.

## Testing Guidelines

Tests use JUnit 5 through `spring-boot-starter-test`. Name test classes with the `*Tests` suffix and keep them in the matching package under `src/test/java`. Add focused tests for route configuration, filters, or custom gateway behavior when those are introduced. Run `./mvnw test` before opening a pull request.

## Commit & Pull Request Guidelines

Recent history uses short Conventional Commit-style messages, for example `docs: adiciona README inicial`. Prefer `type: summary` with types such as `feat`, `fix`, `docs`, `test`, or `chore`. Pull requests should include a brief description, the reason for the change, test results, and any configuration impacts such as new ports, environment variables, or Eureka dependencies.

## Security & Configuration Tips

Do not commit secrets or machine-specific credentials. Keep local overrides outside version control or provide them through environment-specific configuration. Document any new external service dependency in this file or the project README.
