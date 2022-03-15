package com.kourchenko.graphql.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.WorkExperience;
import com.kourchenko.graphql.service.repository.PersonRepository;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import com.kourchenko.graphql.service.repository.WorkExperienceRepository;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    private WorkExperienceService workExperienceService;

    private final PersonRepository personRepository;

    private final ResumeRepository resumeRepository;

    private final WorkExperienceRepository workExperienceRepository;

    public ResumeService(final ResumeRepository resumeRepository,
            final PersonRepository personRepository,
            final WorkExperienceRepository workExperienceRepository) {
        this.resumeRepository = resumeRepository;
        this.personRepository = personRepository;
        this.workExperienceRepository = workExperienceRepository;
    }

    @Transactional
    public Resume createResume() {
        Resume resume = new Resume();

        Date date = new Date();
        resume.setCreatedDate(date);
        resume.setUpdatedDate(date);

        return this.resumeRepository.save(resume);
    }

    @Transactional
    public Resume createResume(Person person) {
        Resume resume = new Resume();

        Date date = new Date();
        resume.setCreatedDate(date);
        resume.setUpdatedDate(date);
        this.personRepository.save(person);

        resume.setPerson(person);

        return this.resumeRepository.save(resume);
    }

    @Transactional
    public Resume createResume(Person person, List<WorkExperience> workExperienceList) {
        System.out.println("[ResumeService] [createResume]");
        Resume resume = new Resume();

        Date date = new Date();
        resume.setCreatedDate(date);
        resume.setUpdatedDate(date);
        this.personRepository.save(person);
        resume.setPerson(person);

        for (WorkExperience w : workExperienceList) {
            this.workExperienceRepository.saveAndFlush(w);
        }
        resume.setWorkExperienceList(new ArrayList<>());
        resume.setWorkExperienceList(workExperienceList);

        resume = this.resumeRepository.save(resume);

        System.out.println("[ResumeService] [createResume] " + resume.getId());
        return resume;
    }

    public List<Resume> getResumeAll() {
        return this.resumeRepository.findAll();
    }

    public Optional<Resume> getResumeById(int id) {
        return this.resumeRepository.findById(id);
    }

}
