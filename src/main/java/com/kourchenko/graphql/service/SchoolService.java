package com.kourchenko.graphql.service;

import java.util.List;
import com.kourchenko.graphql.dao.School;
import com.kourchenko.graphql.service.repository.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(final SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> findByEducationId(int educationId) {
        return this.schoolRepository.findAllByEducationId(educationId);
    }
}
