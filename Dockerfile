FROM openjdk:20-slim
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src/ ./src/
RUN chmod +x mvnw
RUN ./mvnw clean install
CMD ["java", "-jar", "/app/target/fiap-food-0.0.1-SNAPSHOT.jar"]
