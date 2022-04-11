package com.kourchenko.graphql.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.repository.PersonRepository;
import com.kourchenko.graphql.service.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResumeService {
    private static String METHOD = "";

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private PersonRepository personRepository;

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

    public Resume findByResumeId(int resumeId) {
        METHOD = "[ResumeService][findByResumeId]";
        log.error(METHOD + " Finding Resume by ID: " + resumeId, resumeId);
        Optional<Resume> optional = this.resumeRepository.findById(resumeId);
        Resume resume = optional != null ? optional.get() : null;

        if (optional == null || !optional.isPresent() || resume == null) {
            log.error(METHOD + " Resume not found by ID: " + resumeId, resumeId);
            throw new ResumeNotFoundException(METHOD + " Resume not found by ID: " + resumeId,
                    resumeId);
        }

        return resume;
    }
}
