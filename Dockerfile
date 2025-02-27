# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Install Maven dependencies and build the project
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# Run the built JAR
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy JAR file from the build stage
COPY --from=build /app/target/blog-app-apis-0.0.1-SNAPSHOT.jar app.jar

# Expose port 5000
EXPOSE 5000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
