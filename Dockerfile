# Use an official OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy application JAR into the container
COPY build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8081

# Command to run your application
CMD ["java", "-jar", "app.jar"]