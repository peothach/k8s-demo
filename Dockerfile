FROM amazoncorretto:11-alpine-jdk
MAINTAINER NguyenThach
COPY target/k8s-demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/app.jar"]
