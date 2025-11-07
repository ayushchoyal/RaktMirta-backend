# Use lightweight JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file into image
COPY target/RaktMitra-0.0.1-SNAPSHOT.jar app.jar

# Expose default port (optional)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
