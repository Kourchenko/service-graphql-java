package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.WorkExperience;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumeMutation implements GraphQLMutationResolver {

    @Autowired
    private ResumeService resumeService;

    public Resume createResume() {
        return this.resumeService.createResume();
    }

    public Resume createResume(Person person) {
        return this.resumeService.createResume(person);
    }
}
