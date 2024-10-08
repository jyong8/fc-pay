FROM openjdk:11-slim-stretch
EXPOSE 8081
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
