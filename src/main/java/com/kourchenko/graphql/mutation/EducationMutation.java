package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.EducationService;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationMutation implements GraphQLMutationResolver {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private EducationService educationService;

    public List<Education> createEducationList(List<Education> educationList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }
        return educationService.createEducationList(educationList, resumeId);
    }

    public List<Education> addEducationByResumeId(List<Education> educationList, int resumeId) {
        return educationService.addEducationByResumeId(educationList, resumeId);
    }
}
