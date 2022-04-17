package com.kourchenko.graphql.service;

import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Person;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.service.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person createPersonByResumeId(Person person, int resumeId) {
        Resume existingResume = resumeService.findByResumeId(resumeId);
        if (person == null || existingResume == null) {
            return null;
        }

        person.setResume(existingResume);

        return personRepository.save(person);
    }

    @Transactional
    public Person addPersonByResumeId(Person person, int resumeId) {
        Resume existingResume = resumeService.findByResumeId(resumeId);
        if (existingResume == null) {
            return null;
        }

        return personRepository.save(person);
    }

    @Transactional
    public Person updatePersonByResumeId(Person person, int resumeId) {
        Resume existingResume = resumeService.findByResumeId(resumeId);
        if (existingResume == null) {
            return null;
        }

        // Copy Properties or use existing Person
        Person existingPerson = findOneByResumeId(resumeId);
        if (existingPerson != null) {
            if (person != null) {
                BeanUtils.copyProperties(person, existingPerson);
            } else {
                person = existingPerson;
            }
        }

        person.setResume(existingResume);

        return personRepository.save(person);
    }

    @Transactional
    public Person findOneByResumeId(int resumeId) {
        return personRepository.findOneByResumeId(resumeId);
    }
}
