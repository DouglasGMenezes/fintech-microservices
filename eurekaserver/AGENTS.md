# Repository Guidelines

## Project Structure & Module Organization

This repository contains a single Spring Boot Eureka Server service. Application code lives under `src/main/java/br/com/dgm/eurekaserver`, with `EurekaserverApplication.java` as the entry point and Eureka enablement class. Runtime configuration is in `src/main/resources/application.yml`; the service currently runs on port `8761` and does not register itself as a Eureka client. Tests live under `src/test/java/br/com/dgm/eurekaserver`. Build output is generated in `target/` and should not be edited or committed.

## Build, Test, and Development Commands

Use the Maven wrapper so contributors use the project-pinned Maven behavior:

```sh
./mvnw spring-boot:run
```

Starts the Eureka Server locally.

```sh
./mvnw test
```

Runs the JUnit/Spring Boot test suite.

```sh
./mvnw clean package
```

Removes previous build output, runs tests, and creates the packaged artifact in `target/`.

On Windows, use `mvnw.cmd` with the same Maven goals.

## Coding Style & Naming Conventions

The project uses Java 21 with Spring Boot 4 and Spring Cloud dependencies managed in `pom.xml`. Follow standard Java conventions: classes in `PascalCase`, methods and fields in `camelCase`, constants in `UPPER_SNAKE_CASE`, and packages under `br.com.dgm.eurekaserver`. Keep indentation consistent with the existing source, which uses tabs in Java files. Prefer constructor injection for new Spring components and keep configuration in YAML rather than hard-coded values.

## Testing Guidelines

Tests use JUnit 5 through `spring-boot-starter-test`. Place tests in the matching package under `src/test/java`, and name test classes with the `*Tests` suffix, for example `EurekaserverApplicationTests`. Add focused tests for new configuration, startup behavior, or custom components. Run `./mvnw test` before opening a pull request.

## Commit & Pull Request Guidelines

Recent history uses short, descriptive commits, including Conventional Commit-style prefixes such as `docs:`. Prefer messages like `docs: update eureka setup notes` or `feat: add registry health configuration`. Pull requests should include a concise summary, the commands run for verification, related issue links when applicable, and configuration impacts such as port or discovery changes. Include screenshots only when changing user-visible docs or dashboards.

## Security & Configuration Tips

Do not commit secrets, local credentials, or machine-specific paths. Keep environment-specific values outside source control or inject them through environment variables and Spring profiles. Document any required profile or port changes in the PR description.
