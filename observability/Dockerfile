FROM openjdk:18.0.2.1-oraclelinux8

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]