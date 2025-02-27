# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file to the container
COPY target/blog-app-apis-0.0.1-SNAPSHOT.jar app.jar

# Expose port 5000
EXPOSE 5000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]