package com.kourchenko.graphql.service.repository;

import com.kourchenko.graphql.dao.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
