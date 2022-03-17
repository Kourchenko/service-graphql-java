package com.kourchenko.graphql.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.service.repository.PersonRepository;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import com.kourchenko.graphql.service.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    private final PersonRepository personRepository;

    public ResumeService(final ResumeRepository resumeRepository,
            final PersonRepository personRepository,
            final ExperienceRepository workExperienceRepository) {
        this.resumeRepository = resumeRepository;
        this.personRepository = personRepository;
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

    public List<Resume> getResumeAll() {
        return this.resumeRepository.findAll();
    }

    public Resume findByResumeId(int id) {
        return this.resumeRepository.findById(id).get();
    }
}
