FROM openjdk:22
COPY target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]