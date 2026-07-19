# Spring Boot Reactive API

This is a reactive Spring Boot application using WebFlux and MongoDB.

## Project Structure
- Uses Spring Boot 4.1.0 with Java 21
- Reactive MongoDB with WebFlux (non-blocking)
- Lombok for boilerplate reduction
- Gradle build system

## Key Implementation Patterns
- Reactive programming with Reactor (Mono, Flux)
- REST controllers with reactive return types
- MongoDB repository pattern with reactive operations
- Uses CommandLineRunner for initial data population

## Testing Approach
- Integration tests using@SpringBootTest with RANDOM_PORT
- WebTestClient for API testing
- Unit tests for business logic
- Run tests with `./gradlew test`

## Environment Setup
- Requires Lombok plugin in IDE for compilation
- Run with `./gradlew bootRun`
- MongoDB connection configured via Spring Boot auto-configuration
- Default MongoDB connection string from application properties

## Running Tests
The application tests require a running MongoDB instance:

### Option 1: Run MongoDB locally (recommended)
```bash
# Using Docker (recommended)
docker run -d -p 27017:27017 --name mongodb mongo:latest

# Or if you have MongoDB installed locally, start it manually
mongod
```

### Option 2: Skip MongoDB tests (if database isn't needed for testing)
```bash
./gradlew test --tests "org.maxtest.ApplicationTests"
```

## Gotchas
- Lombok annotations may cause IDE compilation issues without proper plugin
- Reactive streams require understanding of Mono/Flux semantics
- Test setup uses WebTestClient with RANDOM_PORT for integration testing
- Ensure MongoDB is running or use docker-compose if available

## Current Test Status
- `ApplicationTests` - PASS: Tests that the Spring context loads correctly
- `ProductControllerTests` - EXPECTED FAILURE: Requires MongoDB connection with proper credentials (see TESTING_INSTRUCTIONS.md)

## Fix Applied
The test has been updated to work with MongoDB authentication using credentials from the docker-compose configuration. If you encounter issues, please ensure:
1. MongoDB is running with proper credentials
2. The correct database user/password are configured in application-test.properties

## Important Note about TestContainers
A TestContainers approach was attempted but requires Docker access in the test environment. For development environments where Docker access isn't available or TestContainers fails, the tests can be skipped using the `--tests` option.

## Testing Instructions
See TESTING_INSTRUCTIONS.md for detailed information on running tests.
