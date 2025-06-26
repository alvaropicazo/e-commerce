MVN = mvn
SERVICES = common order-service product-service user-service
SERVICES_DOCKER = order-service product-service user-service

.PHONY: all clean package test run build-docker

# Default target
all: package

# Compile and package all services
package:
	@for service in $(SERVICES); do \
		echo ">>> Packaging $$service..."; \
		$(MVN) -f $$service/pom.xml clean package -DskipTests; \
	done

# Clean all services
clean:
	@for service in $(SERVICES); do \
		echo ">>> Cleaning $$service..."; \
		$(MVN) -f $$service/pom.xml clean; \
	done

# Run tests
test:
	@for service in $(SERVICES); do \
		echo ">>> Running tests for $$service..."; \
		$(MVN) -f $$service/pom.xml test; \
	done

# Build Docker images
build-docker:
	@for service in $(SERVICES_DOCKER); do \
		echo ">>> Building Docker image for $$service..."; \
		docker build -t $$service ./$$service; \
	done

# Start the application stack
run:
	docker-compose up --build

# Stop the stack
down:
	docker-compose down
