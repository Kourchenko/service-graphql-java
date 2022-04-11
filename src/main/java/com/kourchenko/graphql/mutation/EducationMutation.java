package com.kourchenko.graphql.mutation;

import java.util.ArrayList;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.dao.Resume;
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

    public Education addEducationToResumeById(Education education, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);

        List<Education> educationList = educationService.findAllByResumeId(resumeId);
        educationList = educationList != null ? educationList : new ArrayList<Education>();
        education.setResume(resume);
        educationList.add(education);

        educationService.saveAll(educationList);

        return education;
    }

    public List<Education> createEducationList(List<Education> educationList, int resumeId) {
        return educationService.createEducationList(educationList, resumeId);
    }
}
