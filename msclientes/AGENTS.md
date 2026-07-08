# Repository Guidelines

## Project Structure & Module Organization

This is a Java 21 Spring Boot microservice for customer data (`msclientes`). Source code lives under `src/main/java/br/com/dgm/msclientes` and follows a layered package layout:

- `application/controller`: REST endpoints, currently `ClienteController`.
- `application/service`: business use cases and transaction boundaries.
- `application/representation`: request and response DTOs.
- `application/mapper`: DTO/entity conversion helpers.
- `domain/model`: JPA domain entities.
- `infra/repository`: persistence interfaces.

Configuration is in `src/main/resources/application.yml`. Tests belong in `src/test/java` using the same package structure as production code. Build output in `target/` is generated and should not be edited.

## Build, Test, and Development Commands

Use the Maven wrapper so contributors run the same Maven version:

- `./mvnw spring-boot:run`: starts the service locally. The app registers with Eureka at `http://localhost:8761/eureka` and uses a random server port (`server.port: 0`).
- `./mvnw test`: runs the JUnit/Spring test suite.
- `./mvnw clean package`: cleans generated files, runs tests, and builds the executable jar under `target/`.
- `./mvnw clean`: removes local build artifacts.

## Coding Style & Naming Conventions

Use standard Java conventions with 4-space indentation in main sources. Keep package names lowercase and under `br.com.dgm.msclientes`. Name classes by responsibility and layer, for example `ClienteService`, `ClienteRepository`, `ClienteRequestDTO`, and `ClienteResponseDTO`. Prefer constructor injection. Keep controllers thin: map HTTP input/output there, and place business logic in services.

Lombok is configured as an annotation processor; use it consistently with existing domain/DTO patterns when reducing boilerplate.

## Testing Guidelines

Tests use JUnit 5 with Spring Boot test support. Put test classes in `src/test/java` and name them after the subject, such as `ClienteServiceTest` or `ClienteControllerTest`. Use focused unit tests for mapper/service behavior and Spring tests for application context or web integration. Run `./mvnw test` before opening a pull request.

## Commit & Pull Request Guidelines

Recent history uses concise, imperative commits with an optional type prefix, for example `docs: adiciona README inicial`. Prefer `type: summary` for documentation, features, fixes, and tests, such as `fix: valida cpf no cadastro`.

Pull requests should include a short description, the commands run for verification, linked issues when applicable, and sample requests/responses for API changes. Mention configuration changes, especially anything affecting Eureka, ports, persistence, or environment-specific settings.

## Security & Configuration Tips

Do not commit secrets or machine-specific settings. Keep service discovery and runtime configuration in `application.yml` or environment-specific overrides. The default Eureka URL assumes a local registry on port `8761`; document any different setup in the PR.
