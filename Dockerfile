# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# Stage 2: Create a minimal JRE image and copy the JAR file
FROM azul/zulu-openjdk:17-alpine
WORKDIR /app
COPY --from=build /usr/src/app/target/GeoLocator-1.war /app/app.war

# Expose the port your app will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.war"]
