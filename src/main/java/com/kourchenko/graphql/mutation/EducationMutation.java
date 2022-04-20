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
        return educationService.createEducationList(educationList, resumeId);
    }

    public List<Education> addEducationByResumeId(List<Education> educationList, int resumeId) {
        return educationService.addEducationByResumeId(educationList, resumeId);
    }

    public List<Education> updateEducationListByResumeId(List<Education> educationList,
            int resumeId) {
        return educationService.updateEducationListByResumeId(educationList, resumeId);
    }
}
