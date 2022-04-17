package com.kourchenko.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumeQuery implements GraphQLQueryResolver {

    @Autowired
    private ResumeService resumeService;

    public Resume getResume(int resumeId) {
        return resumeService.getResume(resumeId);
    }
}
