
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests


# Set working directory
WORKDIR /app

# Copy jar file into image
from eclipse-temurin:17-alpine
COPY --from=build /target/RaktMitra-0.0.1-SNAPSHOT.jar app.jar

# Expose default port (optional)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
