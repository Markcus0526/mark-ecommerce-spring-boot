#!/bin/bash

# Exit on any failure
set -e

echo "🚀 Starting Microservices Build Process (Spring Boot 3.3.3 / Java 17)..."

# 1. Compile and package all modules
# We use -DskipTests to speed up the process for deployment
./mvnw clean package -DskipTests

echo "✅ Build Successful. Checking JAR files..."

# 2. Verify critical JARs exist before starting Docker
# This checks one as a representative sample
if [ ! -f "api-gateway/target/api-gateway-v0.1.0.jar" ]; then
    echo "❌ Error: JAR files not found. Check Maven build logs."
    exit 1
fi

echo "🐳 Building Docker images and starting containers..."

# 3. Build and launch the stack
# --build ensures Docker picks up the freshly compiled JARs
docker-compose up --build -d

echo "📊 Current Status:"
docker compose ps

echo "✨ All services are starting up! Check logs with: docker-compose logs -f"
