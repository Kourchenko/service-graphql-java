FROM maven:3.5-jdk-8

WORKDIR /app

COPY . .

RUN mvn clean install

RUN cp target/servicegraphqljava.jar .

EXPOSE 8080

ENTRYPOINT ["mvn", "clean", "spring-boot:run"]
