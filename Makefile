.PHONY: build test lint clean run docker-build docker-up docker-down ci

MVN := ./mvnw
APP_NAME := rest-demo
VERSION := 0.0.1-SNAPSHOT

# === Local Development ===
build:
	$(MVN) clean package -DskipTests

test:
	$(MVN) test

lint:
	$(MVN) checkstyle:check

compile:
	$(MVN) compile

clean:
	$(MVN) clean

run:
	$(MVN) spring-boot:run

# === Docker ===
docker-build:
	docker build -t $(APP_NAME):$(VERSION) .

docker-up:
	docker compose up -d

docker-down:
	docker compose down

docker-logs:
	docker compose logs -f app

# === CI Pipeline ===
ci: lint test build
	@echo "CI passed"
