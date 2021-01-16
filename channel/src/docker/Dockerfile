FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} channeling.jar
ENTRYPOINT ["java","-jar","/channeling.jar"]