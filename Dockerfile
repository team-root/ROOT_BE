FROM amazoncorretto:17 AS build

WORKDIR /app
COPY build.gradle* settings.gradle* ./
COPY gradle gradle
COPY gradlew .
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

COPY src src
RUN ./gradlew bootJar --no-daemon

FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]