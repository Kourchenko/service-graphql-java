package com.kourchenko.graphql.query;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Education;
import com.kourchenko.graphql.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationQuery implements GraphQLQueryResolver {

    @Autowired
    private EducationService educationService;

    public List<Education> findAllByResumeId(int id) {
        return this.educationService.findAllByResumeId(id);
    }
}
