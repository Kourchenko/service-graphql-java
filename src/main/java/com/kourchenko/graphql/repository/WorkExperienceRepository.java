package com.kourchenko.graphql.repository;

import com.kourchenko.graphql.model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {}