# Updated to Java 17 for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Best Practice: Run as a non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Optimized: Only copy the JAR, skipping unnecessary source files
COPY service-discovery/target/service-discovery-v${PROJECT_VERSION}.jar service-discovery.jar

# Eureka Default Port
EXPOSE 8761

# Shell form ensures ${SPRING_PROFILES_ACTIVE} is expanded correctly
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar service-discovery.jar
