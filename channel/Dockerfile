FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/*.jar
COPY ${JAR_FILE} channeling.jar
ENTRYPOINT ["java","-jar","/channeling.jar"]