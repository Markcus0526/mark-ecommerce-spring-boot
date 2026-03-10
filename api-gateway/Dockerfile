# Updated to Eclipse Temurin Java 17 (Recommended for Spring Boot 3.x)
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Set up a secure non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Optimized COPY: only include the JAR file
COPY api-gateway/target/api-gateway-v${PROJECT_VERSION}.jar api-gateway.jar

EXPOSE 8080

# Use shell form to ensure environment variable expansion works correctly
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar api-gateway.jar
