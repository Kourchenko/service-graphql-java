package com.kourchenko.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonQuery implements GraphQLQueryResolver {

    @Autowired
    private PersonService personService;

    public Person findOnePersonByResumeId(int resumeId) {
        return personService.findOneByResumeId(resumeId);
    }
}
