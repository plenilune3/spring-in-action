FROM openjdk:11

EXPOSE 8080

COPY practice-*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
