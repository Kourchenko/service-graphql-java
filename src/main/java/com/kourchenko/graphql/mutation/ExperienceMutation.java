package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.ExperienceService;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMutation implements GraphQLMutationResolver {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ExperienceService experienceService;

    public List<Experience> createExperienceList(List<Experience> experienceList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }
        return experienceService.createExperienceList(experienceList, resumeId);
    }

    public List<Experience> addExperienceByResumeId(List<Experience> experienceList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }
        return experienceService.addExperienceByResumeId(experienceList, resumeId);
    }
}
