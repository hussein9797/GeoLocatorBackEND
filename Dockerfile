# Use Ubuntu as the base image
FROM ubuntu:20.04

# Set environment variables
ENV JAVA_HOME /usr/lib/jvm/openjdk-21
ENV PATH $PATH:$JAVA_HOME/bin

# Install OpenJDK 21
RUN apt-get update \
    && apt-get install -y openjdk-17-jdk \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy your application JAR or other artifacts to the container
COPY your-application.jar /app/

# Command to run your application
CMD ["java", "-jar", "your-application.jar"]
