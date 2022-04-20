package com.kourchenko.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMutation implements GraphQLMutationResolver {

    @Autowired
    private PersonService personService;

    public Person createPersonByResumeId(Person person, int resumeId) {
        return personService.createPersonByResumeId(person, resumeId);
    }

    public Person addPersonByResumeId(Person person, int resumeId) {
        return personService.addPersonByResumeId(person, resumeId);
    }

    public Person updatePersonByResumeId(Person person, int resumeId) {
        return personService.updatePersonByResumeId(person, resumeId);
    }
}
