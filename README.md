# service-graphql-java
GraphQL Endpoint using Docker, MySQL, and JPA.

[![Kourchenko](https://circleci.com/gh/Kourchenko/service-graphql-java.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs)

## GraphQL
```
Class Resume
1. Class Person
    a. String Name
    b. String Email
    c. String Phone Number
2. Class Education
    a. Class School
        i. String Name
        ii. String Address
    b. String Degree
3. Class Experience
    a. String Company Name
    b. String Address
    d. Boolean Is Current Role
    e. Role Title
    f. String Company Name
    g. String Role Title
    h. String Start Date
    i. String End Date
4. Class Projects
    a. String Project Name
    b. String Description
    c. String Role Title
```

### Sample Mutation

```mutation {
  createResume(person: {
    name: "First Name - Last Name",
    emailAddress: null,
    phoneNumber: null
  }) {
    id
  },
  createExperienceList(experienceList: [
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
    id
      isCurrentRole
  },
  createEducationList(educationList: [
    {
      degree: "School Degree",
      schoolList: [
        {
          name: "School Name",
          address: "School Address"
        }
      ]
    }
  ], resumeId: 2) {
    id
    degree,
  }
}
```


### Sample Query
```
query {
  resume(id: 1) {
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

## Data Export
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