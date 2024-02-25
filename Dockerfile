# Stage 1: Build stage - Prepares and Compiles the Application
FROM maven:3.9-amazoncorretto-21 AS builder

# Copy the pom.xml and source code
COPY pom.xml /build/pom.xml
COPY src /build/src

# Compile and package the application
WORKDIR /build
# Using Maven to clean and package the application
RUN mvn -f /build/pom.xml clean package

# Stage 2: Final stage - Copies the Necessary Artifacts
FROM amazoncorretto:21-alpine

# Metadata
LABEL maintainer="tmohamm4@depaul.edu"
LABEL version="1.0"
LABEL description="Simple Java Calculator"

# Copy only the artifacts we need from the builder stage, ensuring only necessary artifacts are moved to the final image
COPY --from=builder /build/target/Calculator-1.0-SNAPSHOT.jar /app/calculator.jar

# Set the working directory
WORKDIR /app

# The command to run the application when the docker container starts
ENTRYPOINT ["java", "-jar", "/app/calculator.jar"]

# The final image uses amazoncorretto:21-alpine, which is a minimal base image for JDK 21
# The Dockerfile's structure with the dependencies copied and installed before adding the application source, maximizes the reusing of layer to optimize for caching