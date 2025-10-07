# Etapa 1: construir el proyecto con Maven
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: ejecutar la aplicación

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar .
RUN mv app-*.jar app.jar || mv *.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]