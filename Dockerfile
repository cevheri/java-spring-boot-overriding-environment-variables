# Spring boot application Dockerfile with overridable environment variables

FROM maven:3.9.8-eclipse-temurin-17-focal AS builder
COPY . /app
WORKDIR /app
RUN mvn clean verify

FROM eclipse-temurin:17.0.9_9-jre-focal
VOLUME /tmp
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]


# Optional environment variables that can be overriden
#ENV APP_PROPERTIES_NAME=overriden-application-name
#ENV APP_ROLES_0=overriden-role-0
#ENV APP_PATHS_0_ROLES_0=overriden-path-0-role-0
