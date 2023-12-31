FROM openjdk:17-jdk-slim
ARG JAR_FILE=JAR_FILE_MUST_BE_SPECIFIED_AS_BUILDING_ARG
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
