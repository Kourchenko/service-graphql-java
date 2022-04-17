package com.kourchenko.graphql.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.service.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private EducationRepository educationRepository;

    @Transactional
    public List<Education> createEducationList(List<Education> educationList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        for (Education education : educationList) {
            education.setResume(resume);
        }
        return educationRepository.saveAll(educationList);
    }

    @Transactional
    public List<Education> addEducationByResumeId(List<Education> educationList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);

        List<Education> existingEducationList = findAllByResumeId(resume.getId());
        for (Education education : educationList) {
            education.setResume(resume);
            existingEducationList.add(education);
        }
        return educationRepository.saveAll(existingEducationList);
    }

    @Transactional
    public List<Education> saveAll(List<Education> educationList) {
        List<Education> savedEducationList =
                educationList != null ? educationList : new ArrayList<>();
        return educationRepository.saveAll(savedEducationList);
    }

    @Transactional
    public List<Education> findAllByResumeId(int resumeId) {
        List<Education> educationList = educationRepository.findAllByResumeId(resumeId);
        educationList = educationList != null ? educationList : new ArrayList<>();
        return educationList;
    }
}
