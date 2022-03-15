package com.kourchenko.graphql.service.repository;

import com.kourchenko.graphql.dao.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {
}
