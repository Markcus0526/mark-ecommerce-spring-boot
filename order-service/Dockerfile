# Switched to Java 17 for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Non-root user for better security
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Only copying the JAR to keep the image slim
COPY order-service/target/order-service-v${PROJECT_VERSION}.jar order-service.jar

EXPOSE 8300

# Using shell form so ${SPRING_PROFILES_ACTIVE} actually works
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar order-service.jar
