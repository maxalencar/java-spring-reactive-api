# Spring Boot Reactive API with MongoDB

This is a reactive Spring Boot application using MongoDB and WebFlux.

## Requirements
- Java 21
- Gradle 9.6.1 (or newer)
- MongoDB instance running locally or via Docker

## Setup Instructions

### Prerequisites
Make sure you have Java 21 installed:
```bash
java -version
```

### Running the Application
1. Start MongoDB (either locally or using Docker):
   ```bash
   docker-compose up -d
   ```

2. Run the application:
   ```bash
   ./gradlew bootRun
   ```

### Building the Project
To build the project:
```bash
./gradlew clean build
```

## API Endpoints
- `GET /products` - Get all products
- `GET /products/{id}` - Get product by ID
- `POST /products` - Create new product
- `PUT /products/{id}` - Update product
- `DELETE /products/{id}` - Delete product
- `DELETE /products` - Delete all products

## Project Structure
- `Application.java` - Main application class with CommandLineRunner
- `controller/` - REST controllers
- `model/` - Data models (with Lombok annotations)
- `repository/` - MongoDB repository interfaces

## Dependencies
- Spring Boot 4.1.0
- Spring WebFlux (reactive)
- Spring Data MongoDB Reactive
- Lombok for boilerplate reduction
