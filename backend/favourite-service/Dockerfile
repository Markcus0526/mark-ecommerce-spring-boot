# Updated to Java 17 (Required for Spring Boot 3.3.3)
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Best Practice: Run as a non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Optimized: Only copy the final JAR
COPY favourite-service/target/favourite-service-v${PROJECT_VERSION}.jar favourite-service.jar

EXPOSE 8800

# Fixed: Use shell form to allow the environment variable to expand properly
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar favourite-service.jar
