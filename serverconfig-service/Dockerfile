FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/serverconfig-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9100
ENTRYPOINT ["java", "-jar", "app.jar"]
