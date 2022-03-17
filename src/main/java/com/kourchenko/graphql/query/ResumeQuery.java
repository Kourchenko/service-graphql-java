package com.kourchenko.graphql.query;

import java.util.ArrayList;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.School;
import com.kourchenko.graphql.service.EducationService;
import com.kourchenko.graphql.service.ExperienceService;
import com.kourchenko.graphql.service.ResumeService;
import com.kourchenko.graphql.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumeQuery implements GraphQLQueryResolver {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private SchoolService schoolService;

    public Resume getResume(int id) {
        Resume resume = this.resumeService.findByResumeId(id);
        List<Education> educationList = this.educationService.findAllByResumeId(id);
        List<Experience> experienceList = this.experienceService.findAllByResumeId(id);

        for (Education education : educationList) {
            List<School> schoolList = this.schoolService.findByEducationId(education.getId());
            education.setSchoolList(schoolList);
        }

        resume.setEducationList(educationList);
        resume.setExperienceList(experienceList);
        resume.setProjectList(new ArrayList<>());

        return resume;
    }
}
