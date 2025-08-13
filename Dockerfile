FROM maven:3.8-openjdk-17 AS builder
LABEL authors="ded_mikhey"

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
LABEL authors="ded_mikhey"

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

RUN mkdir -p /etc/letsencrypt/live/events.olgarhythm.ru

ENV SHOW_SQL=true
EXPOSE 8080 3005 8443

HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl -f http://localhost:3005/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]