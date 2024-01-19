# Use the official maven/Java 17 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.8.4-eclipse-temurin-17 as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# Use the official Java 17 image for a lean production stage of your Spring Boot application.
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:17-jdk-alpine

# Copy the jar file from the builder stage to the production stage.
COPY --from=builder /app/target/GeoLocator-1.war GeoLocator.war

# Expose port 8080 for web access.
EXPOSE 8080

# Run the web service on container startup.
ENTRYPOINT ["java","-jar","/GeoLocator.war"]
