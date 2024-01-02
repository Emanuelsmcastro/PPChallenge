FROM openjdk:22-ea-29-jdk-bookworm
WORKDIR /project
COPY target/ms-user-0.0.1-SNAPSHOT.jar /project/app.jar
RUN apt-get update && apt-get upgrade -y && apt-get install iputils-ping -y
ENTRYPOINT [ "java", "-jar", "app.jar" ]