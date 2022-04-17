# service-graphql-java
GraphQL Endpoint using Docker, MySQL, and SringBoot.

[![Kourchenko](https://circleci.com/gh/Kourchenko/service-graphql-java.svg?style=shield)](https://github.com/Kourchenko/service-graphql-java#service-graphql-java)

## GraphQL
```
Class Resume
1. Class Person
  a. Name
  b. Email Address
  c. Phone Number
2. Class Education
  a. School Name
  b. School Address
  c. School Start Date
  d. School End Date
  e. GPA
  f. Degree Title
  g. Degree Description
3. Class Experience
  a. Is Current Role
  b. Company Name
  c. Company Address
  d. Start Date
  e. End Date
  f. Role Title
  g. Role Description
  h. Role Tools
  i. Role Skills
4. Class Projects
  a. Name
  b. Description
  c. Role Title
```

### Sample Mutation

```
mutation {
  createResume(
    person: {
      name: "Diego Kourchenko",
      emailAddress: "dkourchenko@gmail.com",
      phoneNumber: "(678) 908-0605",
    },
    educationList: [{
      schoolName: "Oregon State",
      schoolAddress: "Corvallis, OR",
      schoolStartDate: "2015-09-01",
      schoolEndDate: "2019-06-01",
      gpa: 3.56,
      degreeTitle: "Bachelor in Computer Science",
      degreeDescription: ""
    }],
    experienceList: [{
      isCurrentRole: true,
      companyName: "Adpearance",
      companyAddress: "Portland, OR",
      startDate: "2020-03-16",
      endDate: "",
      roleTitle: "Developer",
      roleDescription: "",
      roleTools: "",
      roleSkills: ""
    }],
    projectList: [{
      name: "SpeedUpAmerica",
      description: "",
      roleTitle: "Lead Developer"
    }]
  ) {
		id,
    person {
     name,
      emailAddress,
      phoneNumber
    },
    educationList {
      schoolName,
      schoolAddress,
      schoolStartDate,
      schoolEndDate,
      gpa,
      degreeTitle,
      degreeDescription
    },
    experienceList {
      isCurrentRole,
      companyName,
      companyAddress,
      startDate,
      endDate,
      roleTitle,
      roleDescription,
      roleTools,
      roleSkills
    },
    projectList {
      name,
      description,
      roleTitle
    }
  }
}
```

### Sample Query
```
query {
  resume(id: 1) {
    id,
    person {
      name,
      emailAddress,
      phoneNumber
    },
    experienceList {
      isCurrentRole,
      companyName,
      companyAddress,
	    startDate,
      endDate,
      roleTitle,
      roleDescription,
      roleTools,
      roleSkills
    },
    educationList {
      id,
      schoolName,
      schoolAddress,
      schoolStartDate,
      schoolEndDate,
      gpa,
      degreeTitle,
      degreeDescription
    }
  }
}
```
JSON Response
```
{
  "data": {
    "resume": {
      "id": "1",
      "person": {
        "name": "First Name - Last Name",
        "emailAddress": null,
        "phoneNumber": null
      },
      "experienceList": [{
        "isCurrentRole": false,
        "companyName": "Company 1",
        "roleTitle": "Role 1",
        "startDate": "1971-01-01 00:00:00.0",
        "endDate": "1971-01-02 00:00:00.0"
      },
      {
        "isCurrentRole": false,
        "companyName": "Company 2",
        "roleTitle": "Role 2",
        "startDate": "1972-01-01 00:00:00.0",
        "endDate": "1972-01-02 00:00:00.0"
      },
      {
        "isCurrentRole": false,
        "companyName": "Company 3",
        "roleTitle": "Role 3",
        "startDate": "1973-01-01 00:00:00.0",
        "endDate": "1973-01-02 00:00:00.0"
      },
      {
        "isCurrentRole": false,
        "companyName": "Company 4",
        "roleTitle": "Role 4",
        "startDate": "1974-01-01 00:00:00.0",
        "endDate": "1974-01-02 00:00:00.0"
      },
      {
        "isCurrentRole": true,
        "companyName": "Company 5",
        "roleTitle": "Role 5",
        "startDate": "1975-01-01 00:00:00.0",
        "endDate": "1975-01-02 00:00:00.0"
      }],
      "educationList": [{
        "degree": "School Degree"
      }]
    }
  }
}
```

### Postman

<b>POST</b> Query: http://localhost:8080/graphql
```
{
  "query":
    "query {
      resume(id: 1) {
      id,
      person {
        name,
        emailAddress,
        phoneNumber
      },
      experienceList {
        isCurrentRole,
        companyName,
        roleTitle,
        startDate,
        endDate
      },
      educationList {
        degree
      }
    }
  }",
  "variables": null
}
```

cURL
```sh
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: text/plain' \
--data-raw '{
    "query": "query {resume(id: 1) {id, person { name, emailAddress, phoneNumber}, experienceList {isCurrentRole, companyName, roleTitle, startDate, endDate}, educationList {degree, schoolList {name, address} } } }",
    "variables": null
}'
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
> <b>Note:</b> MySQL depends on PORT 3306. You will need to shut down any MySQL servers running on PORT 3306.

> <b>MacOS:</b> System Preferences > MySQL > Stop MySQL Server.

```bash
$ docker-compose up -d
```

## Working with the App
<b>Interactactive GraphQL</b> in your web browser `http://localhost:8080/graphiql`.

<b>Postman requests</b> sent to `http://localhost:8080/graphql` to interact with the data.


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
