FROM openjdk:latest
COPY ./target/Ambry-1.0.0.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Ambry-1.0.0.0-jar-with-dependencies.jar", "db:3306", "30000"]