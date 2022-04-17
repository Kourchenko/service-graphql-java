package com.kourchenko.graphql.query;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienceQuery implements GraphQLQueryResolver {

    @Autowired
    private ExperienceService experienceService;

    public List<Experience> findExperienceListByResumeId(int resumeId) {
        return experienceService.findAllByResumeId(resumeId);
    }
}
