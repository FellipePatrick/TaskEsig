FROM openjdk:21-jdk-slim AS builder
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests
FROM quay.io/wildfly/wildfly AS final
COPY --from=builder target/crud-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/