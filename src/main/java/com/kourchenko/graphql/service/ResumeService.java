package com.kourchenko.graphql.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.dao.Experience;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Project;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private ProjectService projectService;

    @Transactional
    public Resume getResume(int resumeId) {
        Resume resume = findByResumeId(resumeId);
        if (resume == null) {
            return null;
        }

        resume.setEducationList(educationService.findAllByResumeId(resumeId));
        resume.setExperienceList(experienceService.findAllByResumeId(resumeId));
        resume.setProjectList(projectService.findAllByResumeId(resumeId));

        return resume;
    }

    @Transactional
    public Resume createResume() {
        Resume resume = new Resume();

        Date date = new Date();
        resume.setCreatedDate(date);
        resume.setUpdatedDate(date);

        return resumeRepository.save(resume);
    }

    @Transactional
    public Resume createResume(Person person) {
        Resume resume = new Resume();

        Date date = new Date();
        resume.setCreatedDate(date);
        resume.setUpdatedDate(date);
        personService.createPersonByResumeId(person, resume.getId());

        resume.setPerson(person);

        return resumeRepository.save(resume);
    }

    @Transactional
    public Resume createResume(Person person, List<Education> educationList,
            List<Experience> experienceList, List<Project> projectList) {
        Resume resume = createResume();
        person.setResume(resume);

        int resumeId = resume.getId();
        resume.setPerson(personService.createPersonByResumeId(person, resumeId));
        resume.setEducationList(educationService.createEducationList(educationList, resumeId));
        resume.setExperienceList(experienceService.createExperienceList(experienceList, resumeId));
        resume.setProjectList(projectService.createProjectList(projectList, resumeId));

        return resume;
    }

    @Transactional
    public List<Resume> getResumeAll() {
        return resumeRepository.findAll();
    }

    @Transactional
    public Resume findByResumeId(int resumeId) {
        Optional<Resume> optional = resumeRepository.findById(resumeId);
        Resume resume = optional.isPresent() ? optional.get() : null;

        return resume;
    }
}
