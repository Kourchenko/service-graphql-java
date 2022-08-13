FROM 861920639236.dkr.ecr.us-west-2.amazonaws.com/maven-3.5-jdk-8:latest

RUN mvn clean install -DskipTests

WORKDIR /app

COPY . /app
RUN mvn -v

RUN mvn verify clean --fail-never

EXPOSE 8080

COPY ./target/ervice-graphql-java.jar /app

ENTRYPOINT ["java", "-jar", "/app/service-graphql-java.jar"]
