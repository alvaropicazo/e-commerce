# E-COMMERCE

This e-commerce backend application follows a microservice approach written in Java using Spring Boot.

### Microservices:
- DTO to carry data between layers — typically requests from users (input) and responses back to clients (output).
- Model to represent the domain or database entity, usually annotated with @Entity for JPA (Java Persistence API).
- Repository is the data access layer that handles CRUD operations on the model using Spring Data JPA.
- Service is the business logic layer. It takes input, applies rules, talks to repositories, and prepares output.
- Controller is the entry point for HTTP requests (via @RestController). It maps URLs and methods.

### PostgresSQL:
Run `tables_script.sql` to set the DB appropriately.

### For Entities, UUIDs are used.
Why it's important:
- 🧵 Safe for distributed systems (no need for centralized ID generation)

- ✅ Avoids collision across microservices

- 📦 Easier to share identifiers across systems or services

- 🔐 Obfuscates your internal DB structure better than incremental IDs

### Use Makefile for the following tasks
make           # Build all services
make clean     # Clean all
make test      # Run tests
make build-docker      # Build docker images
make run      # Docker-compose up
make down      # Docker-compose down
