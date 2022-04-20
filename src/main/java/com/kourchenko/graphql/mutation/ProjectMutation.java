package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Project;
import com.kourchenko.graphql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMutation implements GraphQLMutationResolver {

    @Autowired
    private ProjectService projectService;

    public List<Project> createProjectList(List<Project> experienceList, int resumeId) {
        return projectService.createProjectList(experienceList, resumeId);
    }

    public List<Project> addProjectByResumeId(List<Project> experienceList, int resumeId) {
        return projectService.addProjectByResumeId(experienceList, resumeId);
    }
}
