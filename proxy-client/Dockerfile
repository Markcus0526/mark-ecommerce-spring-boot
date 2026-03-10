# Java 17 is the baseline for Spring Boot 3.3.3
FROM eclipse-temurin:17-jre-jammy
ARG PROJECT_VERSION=0.1.0

# Best Practice: Use a non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev

# Copy only the JAR to keep the image slim
COPY proxy-client/target/proxy-client-v${PROJECT_VERSION}.jar proxy-client.jar

EXPOSE 8900

# Shell form ensures ${SPRING_PROFILES_ACTIVE} expands correctly
ENTRYPOINT java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar proxy-client.jar
