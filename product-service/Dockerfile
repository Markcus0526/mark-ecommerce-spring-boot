# Java 17 is mandatory for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Run as non-root for production security
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Only include the artifact, skip the source code
COPY product-service/target/product-service-v${PROJECT_VERSION}.jar product-service.jar

EXPOSE 8500

# Switched to shell form so ${SPRING_PROFILES_ACTIVE} is properly parsed
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar product-service.jar
