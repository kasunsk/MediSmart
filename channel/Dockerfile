FROM openjdk:8-jdk-alpine
RUN mkdir app
RUN mkdir temp
VOLUME /temp
ARG JAR_FILE=/*.jar
COPY ${JAR_FILE} /app/channeling.jar
ENTRYPOINT ["java","-jar","/app/channeling.jar"]