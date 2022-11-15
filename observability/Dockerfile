FROM openjdk:18.0.2.1-oraclelinux8

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

COPY target/*.jar app.jar

EXPOSE 8080

#ENTRYPOINT [ "java", "-javaagent:opentelemetry-javaagent.jar", "-Dotel.service.name=observability", "-Dotel.traces.exporter=zipkin", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]
ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]