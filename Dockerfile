FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/roommate-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","app.war"]
