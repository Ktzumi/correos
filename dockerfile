# Etapa 1: Construcción con Maven
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución del JAR generado
FROM eclipse-temurin:21-jdk
WORKDIR /app
# Copiar el JAR generado (cualquier nombre) desde la etapa de build
COPY --from=build /app/target/*.jar /app/app.jar
# Verifica que realmente existe
RUN ls -l /app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]