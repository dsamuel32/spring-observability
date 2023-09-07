FROM maven:latest AS build
WORKDIR /build

COPY spotify-consumer-api .

RUN mvn package -DskipTests

FROM openjdk:18-alpine as release

COPY --from=build /build/infrastructure/target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java" ,"-jar" "-Dspring.profiles.active=dev=prod", "./app.jar"]