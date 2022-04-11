package com.kourchenko.graphql.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import com.kourchenko.graphql.service.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Transactional
    public List<Education> createEducationList(List<Education> educationList, int resumeId) {
        Optional<Resume> optional = this.resumeRepository.findById(resumeId);
        Resume resume = optional != null ? optional.get() : null;

        for (Education education : educationList) {
            education.setResume(resume);
        }

        return this.educationRepository.saveAll(educationList);
    }

    public List<Education> saveAll(List<Education> educationList) {
        return this.educationRepository.saveAll(educationList);
    }

    public List<Education> findAllByResumeId(int id) {
        return this.educationRepository.findAllByResumeId(id);
    }
}
