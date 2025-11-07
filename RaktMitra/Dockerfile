# ===== Stage 1: Build the JAR =====
FROM maven:3.9.4-eclipse-temurin-17 AS build

COPY . .

# Package the app (skip tests for faster build)
RUN mvn clean package -DskipTests

# ===== Stage 2: Run the app =====
FROM eclipse-temurin:17-jdk-alpine



# Copy jar from build stage
COPY --from=build /RaktMitra/target/RaktMitra-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
