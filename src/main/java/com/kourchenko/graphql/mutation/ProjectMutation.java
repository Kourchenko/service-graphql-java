package com.kourchenko.graphql.mutation;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kourchenko.graphql.dao.Project;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.error.ResumeNotFoundException;
import com.kourchenko.graphql.service.ProjectService;
import com.kourchenko.graphql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMutation implements GraphQLMutationResolver {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ProjectService projectService;

    public List<Project> createProjectList(List<Project> experienceList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        return projectService.createProjectList(experienceList, resumeId);
    }

    public List<Project> addProjectByResumeId(List<Project> experienceList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);
        if (resume == null) {
            throw new ResumeNotFoundException("Resume Not Found.");
        }

        return projectService.addProjectByResumeId(experienceList, resumeId);
    }
}
