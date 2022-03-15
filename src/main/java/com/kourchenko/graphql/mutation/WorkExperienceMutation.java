package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.WorkExperience;
import com.kourchenko.graphql.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkExperienceMutation implements GraphQLMutationResolver {

    @Autowired
    private WorkExperienceService workExperienceService;

    public List<WorkExperience> createWorkExperience(List<WorkExperience> workExperienceList,
            int resumeId) {
        return this.workExperienceService.createWorkExperience(workExperienceList, resumeId);
    }

}
