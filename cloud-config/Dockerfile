# Updated to Java 17 for Spring Boot 3.3.3 compatibility
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Best Practice: Use a non-root user for security
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app

# Only copy the JAR to keep the image lean
COPY cloud-config/target/cloud-config-v${PROJECT_VERSION}.jar cloud-config.jar

EXPOSE 9296

# Standard entrypoint for executing the JAR
ENTRYPOINT ["java", "-jar", "cloud-config.jar"]
