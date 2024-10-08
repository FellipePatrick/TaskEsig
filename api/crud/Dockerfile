FROM openjdk:21-jdk-slim
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "target/sic-0.0.1-SNAPSHOT.jar"]