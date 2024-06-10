
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY .. /app

VOLUME /tmp

ARG JAR_FILE=target/webService-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]