package com.kourchenko.graphql.query;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kourchenko.graphql.dao.Project;
import com.kourchenko.graphql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectQuery implements GraphQLQueryResolver {

    @Autowired
    private ProjectService projectService;

    public List<Project> findProjectListByResumeId(int resumeId) {
        return projectService.findAllByResumeId(resumeId);
    }
}
