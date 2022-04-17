package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Project;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumeMutation implements GraphQLMutationResolver {

    @Autowired
    private ResumeService resumeService;

    public Resume createResume(Person person) {
        return resumeService.createResume(person);
    }

    public Resume createResume(Person person, List<Education> educationList,
            List<Experience> experienceList, List<Project> projectList) {
        return resumeService.createResume(person, educationList, experienceList, projectList);
    }
}
