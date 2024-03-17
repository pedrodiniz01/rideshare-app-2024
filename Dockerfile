# Maven base image
FROM maven:3.8.4 AS builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml file to install dependencies
COPY pom.xml .

# Install dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Create .jar
RUN mvn clean install

# Start a new stage
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file from the previous stage
COPY --from=builder /app/target/rideshare-0.0.1-SNAPSHOT.jar .

# Expose the ports for Spring Boot and Kafka
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "rideshare-0.0.1-SNAPSHOT.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]
