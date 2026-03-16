# Java 17 is the mandatory baseline for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Security best practice: avoid running as root
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Optimized: Only copy the artifact, not the source code
COPY shipping-service/target/shipping-service-v${PROJECT_VERSION}.jar shipping-service.jar

EXPOSE 8600

# Shell form allows the environment variable to be evaluated
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar shipping-service.jar
