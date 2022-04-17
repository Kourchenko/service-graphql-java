package com.kourchenko.graphql.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import com.kourchenko.graphql.dao.Resume;
import com.kourchenko.graphql.dao.Project;
import com.kourchenko.graphql.service.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public List<Project> createProjectList(List<Project> projectList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);

        for (Project project : projectList) {
            project.setResume(resume);
        }
        return projectRepository.saveAll(projectList);
    }

    @Transactional
    public List<Project> addProjectByResumeId(List<Project> projectList, int resumeId) {
        Resume resume = resumeService.findByResumeId(resumeId);

        List<Project> existingProjectList = findAllByResumeId(resume.getId());

        for (Project project : projectList) {
            project.setResume(resume);
            existingProjectList.add(project);
        }
        return projectRepository.saveAll(existingProjectList);
    }

    @Transactional
    public List<Project> saveAll(List<Project> projectList) {
        List<Project> savedProjectList = projectList != null ? projectList : new ArrayList<>();
        return projectRepository.saveAll(savedProjectList);
    }

    @Transactional
    public List<Project> findAllByResumeId(int resumeId) {
        List<Project> projectList = projectRepository.findAllByResumeId(resumeId);
        projectList = projectList != null ? projectList : new ArrayList<>();
        return projectList;
    }
}
