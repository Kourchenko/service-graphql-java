package com.kourchenko.graphql.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private PersonRepository personRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Person createPersonByResumeId(Person person, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        if (person == null) {
            return null;
        }

        person.setResume(resume);

        return personRepository.save(person);

    }

    @Transactional
    public Person addPersonByResumeId(Person person, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        person.setResume(resume);

        return personRepository.save(person);
    }

    @Transactional
    public Person updatePersonByResumeId(Person person, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        // Copy Properties or use existing Person
        Person existingPerson = findOneByResumeId(resumeId);
        if (existingPerson != null) {
            if (person != null) {
                existingPerson.merge(person);
            } else {
                person = existingPerson;
            }
        }
        existingPerson.setResume(resume);

        return personRepository.save(existingPerson);
    }

    @Transactional
    public Person findOneByResumeId(int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        return personRepository.findOneByResumeId(resumeId);
    }
}
