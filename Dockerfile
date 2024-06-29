# Use a base image that has Java 17 installed
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build/libs directory to the working directory in the container
COPY build/libs/challangeIngenia-0.0.1-SNAPSHOT.jar /app/challangeIngenia.jar

# Specify the entry point to run the jar file
ENTRYPOINT ["java", "-jar", "challangeIngenia.jar"]
