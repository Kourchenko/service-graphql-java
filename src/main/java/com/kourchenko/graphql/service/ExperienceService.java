package com.kourchenko.graphql.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.service.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Transactional
    public List<Experience> createExperienceList(List<Experience> experienceList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }
        for (Experience experience : experienceList) {
            experience.setResume(resume);
        }

        return experienceRepository.saveAll(experienceList);
    }

    @Transactional
    public List<Experience> addExperienceByResumeId(List<Experience> experienceList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        List<Experience> existingExperienceList = findAllByResumeId(resume.getId());
        for (Experience experience : experienceList) {
            experience.setResume(resume);
            existingExperienceList.add(experience);
        }

        return experienceRepository.saveAll(existingExperienceList);
    }

    @Transactional
    public List<Experience> saveAll(List<Experience> experienceList) {
        List<Experience> savedExperienceList =
                experienceList != null ? experienceList : new ArrayList<>();
        return experienceRepository.saveAll(savedExperienceList);
    }

    @Transactional
    public List<Experience> findAllByResumeId(int resumeId) {
        List<Experience> experienceList = experienceRepository.findAllByResumeId(resumeId);
        experienceList = experienceList != null ? experienceList : new ArrayList<>();
        return experienceList;
    }
}
