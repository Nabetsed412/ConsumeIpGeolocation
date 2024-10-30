FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/ConsumeIpGeolocation-0.0.1-SNAPSHOT.jar /app/ConsumeIpGeolocation.jar
ENTRYPOINT ["java", "-jar", "ConsumeIpGeolocation.jar"]