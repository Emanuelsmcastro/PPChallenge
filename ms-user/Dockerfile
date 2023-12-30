FROM openjdk:21
WORKDIR /project
COPY target/ms-user-0.0.1-SNAPSHOT.jar /project/app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]