package com.kourchenko.graphql.service;

import java.util.List;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.WorkExperience;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import com.kourchenko.graphql.service.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceService {

    private final ResumeRepository resumeRepository;

    private final WorkExperienceRepository workExperienceRepository;

    public WorkExperienceService(final ResumeRepository resumeRepository,
            final WorkExperienceRepository workExperienceRepository) {
        this.resumeRepository = resumeRepository;
        this.workExperienceRepository = workExperienceRepository;
    }

    @Transactional
    public List<WorkExperience> createWorkExperience(List<WorkExperience> workExperienceList,
            int resumeId) {
        Resume resume = this.resumeRepository.findById(resumeId).get();

        for (WorkExperience workExperience : workExperienceList) {
            workExperience.setResume(resume);
        }

        return this.workExperienceRepository.saveAll(workExperienceList);
    }

}
