FROM maven:3.9.9-eclipse-temurin-21-alpine

WORKDIR /app
COPY . .

# Esto permite usar DevTools para hot reload si lo tienes configurado
CMD ["mvn", "spring-boot:run"]
