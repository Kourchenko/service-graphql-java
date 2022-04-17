package com.kourchenko.graphql.service.repository;

import java.util.List;
import com.kourchenko.graphql.dao.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    public List<Project> findAllByResumeId(int resumeId);
}
