package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationMutation implements GraphQLMutationResolver {

    @Autowired
    private EducationService educationService;

    public List<Education> createEducationList(List<Education> educationList, int resumeId) {
        return this.educationService.createEducationList(educationList, resumeId);
    }
}
