FROM maven:3.9.5 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app

RUN mvn clean package

FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=reto-0.0.1.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","reto-0.0.1.jar"]
