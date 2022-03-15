# service-graphql-java
GraphQL Endpoint using Docker, MySQL, and JPA.

# Template:
[![Kourchenko](https://circleci.com/gh/Kourchenko/service-graphql-java.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs)

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

Use Postman to hit `http://localhost:8080/graphiql` to interact with the data.


## Stopping the app

```bash
$ docker-compose down
```

### Data Export
Replace `<date>` with the the current data export date `010520`.sql.
```bash
docker-compose exec mysql mysqldump --no-create-info -u suyc -psuyc suyc --ignore-table=suyc.schema_migerations > <date>.sql
```

## GraphQL
### Sample Mutation

```
mutation {
  createResume(person: {
    firstName: "First Name",
    lastName: "Last Name",
    emailAddress: null,
    phoneNumber: null
  }) {
    id
  },
  createWorkExperience(workExperienceList: [
    {
      isCurrentRole: false,
      companyName: "Company 1",
      roleTitle: "Role 1",
      startDate: "1971-01-01",
      endDate: "1971-01-02",
    },
    {
      isCurrentRole: false,
      companyName: "Company 2",
      roleTitle: "Role 2",
      startDate: "1972-01-01",
      endDate: "1972-01-02",
    },
    {
      isCurrentRole: false,
      companyName: "Company 3",
      roleTitle: "Role 3",
      startDate: "1973-01-01",
      endDate: "1973-01-02",
    },
    {
      isCurrentRole: false,
      companyName: "Company 4",
      roleTitle: "Role 4",
     	startDate: "1974-01-01",
      endDate: "1974-01-02",
    },
    {
      isCurrentRole: true,
      companyName: "Company 5",
    	roleTitle: "Role 5",
     	startDate: "1975-01-01",
      endDate: "1975-01-02",
    }
  ], resumeId: 2) {
		isCurrentRole
  }
}
```


### Sample Query
```
query {
  resume(id: 2) {
    id
    person {
      firstName
      lastName
      emailAddress
      phoneNumber
    }
    workExperienceList {
      isCurrentRole,
      companyName,
      roleTitle
			startDate,
      endDate
    }
  }
}
```


## Tech Stack
The application utilizies the following technologies and languages:
- Java
- Docker CE
- MySQL
- [GraphQL-Java](https://www.graphql-java.com/)
- SpringBoot
- JPA/Hibernate