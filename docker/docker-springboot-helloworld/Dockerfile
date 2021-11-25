FROM openjdk:8
EXPOSE 8080
ADD target/docker-test-0.0.1-SNAPSHOT.jar docker-test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "docker-test-0.0.1-SNAPSHOT.jar"]