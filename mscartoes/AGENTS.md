# Repository Guidelines

## Project Structure & Module Organization
This repository is a Spring Boot microservice for `mscartoes`. Source code lives under `src/main/java/br/com/dgm/mscartoes`, with domain code currently starting at `domain/model`. Configuration files live in `src/main/resources`, and tests are in `src/test/java`.

Keep the DDD direction simple: prefer clear packages such as `domain`, `application`, `infrastructure`, and `interfaces` when the codebase grows. Avoid creating extra layers unless they solve a real need.

## Build, Test, and Development Commands
- `./mvnw clean package` - compiles the project and builds the JAR.
- `./mvnw test` - runs the test suite.
- `./mvnw spring-boot:run` - starts the service locally.

Use the Maven Wrapper from the repository root so everyone builds with the same Maven version.

## Coding Style & Naming Conventions
Use Java 21 and keep the code straightforward and readable. Follow standard Spring conventions:
- Packages in lowercase, grouped by responsibility.
- Classes and records in `PascalCase`.
- Methods and fields in `camelCase`.
- Prefer records for DTOs when the data is immutable.
- Use dedicated mapper classes instead of ad hoc conversion logic.

Indentation should follow the existing code style in the repository. Keep comments brief and only when they add clarity.

## Testing Guidelines
Use JUnit 5 with Spring Boot tests when needed. Name test classes with the `*Test` or `*Tests` suffix, matching the production class name.

Prefer focused tests for domain rules and service behavior. Run `./mvnw test` before opening a pull request. If a test depends on external services like Eureka, isolate that dependency with configuration or profiles.

## Commit & Pull Request Guidelines
Recent commits use short, descriptive messages, often with a scope, such as `msclientes: Add end-point aditCliente()` or `docs: adiciona README inicial`. Follow the same style: concise imperative message, optionally prefixed by the module.

Pull requests should include:
- a short summary of the change,
- the reason for the change,
- tests run locally,
- notes about any configuration or behavior impact.

## Configuration & Safety Tips
Do not commit secrets or environment-specific settings. Keep application configuration in `src/main/resources/application.yaml` and use profiles when local-only settings are needed.
