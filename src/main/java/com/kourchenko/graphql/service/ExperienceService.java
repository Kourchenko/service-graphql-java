package com.kourchenko.graphql.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import com.kourchenko.graphql.service.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Transactional
    public List<Experience> createExperienceList(List<Experience> experienceList, int resumeId) {
        Optional<Resume> optional = this.resumeRepository.findById(resumeId);
        Resume resume = optional != null ? optional.get() : null;

        for (Experience experience : experienceList) {
            experience.setResume(resume);
        }

        return this.experienceRepository.saveAll(experienceList);
    }

    public List<Experience> findAllByResumeId(int id) {
        return this.experienceRepository.findAllByResumeId(id);
    }
}
