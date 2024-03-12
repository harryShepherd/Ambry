FROM openjdk:latest
COPY ./target/Ambry-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Ambry-0.1.0.1-jar-with-dependencies.jar", "db:3306", "30000"]