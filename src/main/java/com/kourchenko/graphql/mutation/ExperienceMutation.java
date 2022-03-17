package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMutation implements GraphQLMutationResolver {

    @Autowired
    private ExperienceService experienceService;

    public List<Experience> createExperienceList(List<Experience> experienceList, int resumeId) {
        return this.experienceService.createExperienceList(experienceList, resumeId);
    }

}
