FROM openjdk:22-ea-29-jdk-bookworm
WORKDIR /project
COPY target/gateway-server-0.0.1-SNAPSHOT.jar /project/app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]