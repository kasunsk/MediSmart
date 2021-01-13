FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/*.jar
COPY ${JAR_FILE} channel.jar
ENTRYPOINT ["java","-jar","/channel.jar"]