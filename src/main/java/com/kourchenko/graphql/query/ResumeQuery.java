package com.kourchenko.graphql.query;

import java.util.ArrayList;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.EducationService;
import com.kourchenko.graphql.service.ExperienceService;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ResumeQuery implements GraphQLQueryResolver {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private ExperienceService experienceService;

    public Resume getResume(int id) {
        Resume resume = this.resumeService.findByResumeId(id);
        if (resume == null) {
            log.error("[ResumeService][getResume] Resume not found", id);
            throw new ResumeNotFoundException("[ResumeService][getResume] Resume not found", id);
        }

        List<Education> educationList = this.educationService.findAllByResumeId(id);
        List<Experience> experienceList = this.experienceService.findAllByResumeId(id);

        resume.setEducationList(educationList);
        resume.setExperienceList(experienceList);
        resume.setProjectList(new ArrayList<>());

        return resume;
    }
}
