package com.kourchenko.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.PersonService;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMutation implements GraphQLMutationResolver {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private PersonService personService;

    public Person createPersonByResumeId(Person person, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }
        return personService.createPersonByResumeId(person, resumeId);
    }

    public Person addPersonByResumeId(Person person, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }
        return personService.addPersonByResumeId(person, resumeId);
    }
}
