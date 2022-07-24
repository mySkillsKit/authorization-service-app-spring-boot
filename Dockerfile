FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/authorization-service-app-spring-boot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]