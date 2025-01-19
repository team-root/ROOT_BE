FROM amazoncorretto:17 AS build
COPY . .
RUN chmod +x gradlew && ./gradlew bootJar

FROM amazoncorretto:17-alpine
COPY --from=build build/libs/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]