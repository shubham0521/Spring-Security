# User Authentication System

A Spring Boot application implementing secure user authentication using Spring Security.

## Features

- User registration and authentication
- Secure password storage with BCrypt encryption
- RESTful API endpoints
- PostgreSQL database integration
- Role-based authorization

## Tech Stack

- Java 21
- Spring Boot 3.5.0
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## API Endpoints

- `POST /user/register` - Register new user
- `GET /user/hello` - Protected endpoint (requires authentication)
- `POST /user/login` - User login

## Security Features

- BCrypt password encryption
- Basic authentication
- Custom user details service
- Role-based access control

## Project Structure

```
src/main/java/
├── config/         # Security and application configurations
├── controller/     # REST API endpoints
├── service/        # Business logic
├── repository/     # Database access
├── entity/         # Database models
└── dto/           # Data transfer objects
```

## Getting Started

1. Ensure you have Java 21 and Maven installed
2. Configure PostgreSQL database
3. Run the application:
   ```bash
   mvn spring-boot:run
   ``` 