# service-graphql-java
GraphQL Endpoint using Docker, MySQL, and JPA.

## Setup

Install [Docker](https://docs.docker.com/install/#supported-platforms) and [Docker Compose](https://docs.docker.com/compose/install/).

```bash
$ git clone https://github.com/Kourchenko/service-graphql-java
$ cd service-graphql-java
$ docker-compose up
```

> Docker-Compose is already included with Mac and Windows installs, but not Linux.

> Please note that Windows Home differs from Windows Pro for Docker installations.

## Running the App

```bash
$ docker-compose up -d
```

Use Postman to hit `http://localhost:8080/allWorkExperience` to interact with the application.


## Stopping the app

```bash
$ docker-compose down
```

### Data Export
Replace `<date>` with the the current data export date `010520`.sql.
```bash
docker-compose exec mysql mysqldump --no-create-info -u suyc -psuyc suyc --ignore-table=suyc.schema_migerations > <date>.sql
```


## Tech Stack
The application utilizies the following technologies and languages:
- Java
- Docker CE
- MySQL
- [GraphQL-Java](https://www.graphql-java.com/)
- SpringBoot
- JPA/Hibernate