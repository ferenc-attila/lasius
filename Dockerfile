FROM gradle:8.12.1-jdk23 AS build
WORKDIR /app
COPY . .
RUN gradle buildFatJar --no-daemon

FROM openjdk:23-slim
WORKDIR /app
COPY --from=build /app/build/libs/*-all.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
