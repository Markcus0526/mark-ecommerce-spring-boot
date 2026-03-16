# Updated to Java 17 for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Security: Run as a non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Only copy the JAR file to keep the image slim
COPY payment-service/target/payment-service-v${PROJECT_VERSION}.jar payment-service.jar

EXPOSE 8400

# Shell form is required to expand ${SPRING_PROFILES_ACTIVE}
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar payment-service.jar
