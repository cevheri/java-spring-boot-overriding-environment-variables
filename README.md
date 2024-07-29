# Spring Boot Overriding Environment Variables Guide


This is an example of overriding the application.yml file with the OS environment variables. 
`Single` or `Array` environment variables can be overridden.

![img.png](images/title.png)

We talk about many ways to override environment variables in a Spring Boot application. Not auto-configuration :(

---

## Understanding Environment Variables
* Your Spring Boot application has a `application.yml` or `application.properties` file.
* The application properties are converted to environment variables when you run the Spring Boot application.
* The environment variables are key-value pairs that are set in the operating system.
* They are used to configure applications and services.
* Many ways to override environment variables in a Spring Boot application.

---

## Overview
1. This guide will show you how to override environment variables in a Spring Boot application.
2. Single and array environment variables will be overridden.
3. When you run a Spring Boot application, the application properties are converted to environment variables.
4. You can override environment variables using the `-D` flag when java -jar is used.
5. You can override environment variables using the `-e` flag when running a Spring Boot application in a Docker container.
6. You can override environment variables using ConfigMaps and Secrets when running a Spring Boot application in a Kubernetes cluster.
7. You can override environment variables using the `application.yml` file from git repository with spring cloud config server.

----

## Prerequisites
* JDK 17
* Maven 3.9x
* Spring Boot 3x

---

## Getting Started
* Clone the repository
```shell
git clone https://github.com/cevheri/spring-boot-overriding-environment-variables.git
```

* Change directory
```shell
cd spring-boot-overriding-environment-variables
```

* Run the Spring Boot application
```shell
mvn spring-boot:run
```

---


## Our Use Cases
![img.png](images/uses-cases.png)
4 and 5 are the most common use cases for overriding environment variables in a Spring Boot application. Maybe next time we can talk about the Kubernetes and Spring Cloud Config Server use cases.

---

## Environments Naming Convention
When you run a Spring Boot application, the application properties are converted to environment variable like UPPER_CASE with underscores.

* application.yml file
```yml
app-properties:
  name: "Spring Boot Overriding Environment Variables"
  version: "0.0.1"
  description: "Spring Boot Overriding Environment Variables with application.yml"
  author: "Cevheri"
  email: "cevheribozoglan@gmail.com"
```
* OS Environment Variable
```shell
APP_PROPERTIES_NAME=overridden-name
APP_PROPERTIES_VERSION=overridden-version
APP_PROPERTIES_DESCRIPTION=overridden-description
APP_PROPERTIES_AUTHOR=overridden-author
APP_PROPERTIES_EMAIL=overridden-email
```

---

## Use Cases
Environment variables are key-value pairs that are set in the operating system.
They are used to configure applications and services.

### java -jar
When you run a Spring Boot application using the `java -jar` command, you can override environment variables using the `-D` flag.



### docker run
When you run a Spring Boot application in a Docker container, you can override environment variables using the `-e` flag.
    

---

## Build
### Maven Build
```shell
mvn clean install
```

### Build Docker Image
```shell
docker build -t soe:latest .
```

---

## Run
Run the Spring Boot application using the `java -jar` command. 

### Java
#### Simple
```shell
java -jar target/soe.jar
```
![default-values.png](images/default-values.png)
---

#### Override Environment Variables
```shell
java -jar '-Dapp-properties.name=overridden-name-cevheri' '-Dapp-roles[0]=overridden-role-0-cevheri' '-Dapp-paths[0].roles[4]=overridden-path-0-role-0-cevheri' target/soe.jar
```
![overrided-values.png](images/overrided-values.png)
---

### Docker
#### Simple
```shell
docker run -p 8080:8080 soe:latest
```
![docker-default-values.png](images/docker-default-values.png)
#### Override Environment Variables
```shell
docker run -p 8080:8080 -e APP_PROPERTIES_NAME=overridden-name-cevheri-docker -e APP_ROLES_0=overridden-role-0-cevheri-docker -e APP_PATHS_0_ROLES_4=overridden-path-0-role-0-cevheri-docker soe:latest
```
![docker-overrided-values.png](images/docker-overrided-values.png)


## Test

```shell
mvn test
```

---

## Conclusion
* This guide showed you how to override environment variables in a Spring Boot application. 
* Single and multiple(array) environment variables were overridden. 
* When you run a Spring Boot application, the application properties are converted to environment variables. 
* You can override environment variables using the `-D` flag when java -jar is used. 
* You can override environment variables using the `-e` flag when running a Spring Boot application in a Docker container.

---

### Reference Documentation

For further reference, please consider the following sections:
* https://spring.io/guides/gs/spring-boot
* https://docs.spring.io/spring-boot/reference/features/external-config.html
* https://maven.apache.org/guides/index.html
* https://docs.spring.io/spring-boot/3.3.2/maven-plugin
* https://docs.spring.io/spring-boot/3.3.2/maven-plugin/build-image.html
* https://docs.docker.com/compose/environment-variables/set-environment-variables/
