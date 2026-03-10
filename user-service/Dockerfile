# Java 17 is required for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Best Practice: Run as a non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Only copy the JAR to keep the image lean
COPY user-service/target/user-service-v${PROJECT_VERSION}.jar user-service.jar

EXPOSE 8700

# Shell form allows ${SPRING_PROFILES_ACTIVE} to resolve correctly
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar user-service.jar
