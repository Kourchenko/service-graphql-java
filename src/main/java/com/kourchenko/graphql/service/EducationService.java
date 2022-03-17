package com.kourchenko.graphql.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.School;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import com.kourchenko.graphql.service.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    private final ResumeRepository resumeRepository;

    private final EducationRepository educationRepository;

    public EducationService(final ResumeRepository resumeRepository,
            final EducationRepository educationRepository) {
        this.resumeRepository = resumeRepository;
        this.educationRepository = educationRepository;
    }

    @Transactional
    public List<Education> createEducationList(List<Education> educationList, int resumeId) {
        Optional<Resume> optional = this.resumeRepository.findById(resumeId);
        Resume resume = optional != null ? optional.get() : null;

        for (Education education : educationList) {
            for (School school : education.getSchoolList()) {
                school.setEducation(education);
            }
            education.setResume(resume);
        }

        return this.educationRepository.saveAll(educationList);
    }
}
