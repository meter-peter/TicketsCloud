
FROM openjdk:20
WORKDIR /app
COPY out/artifacts/TicketsCloud_jar/TicketsCloud.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
