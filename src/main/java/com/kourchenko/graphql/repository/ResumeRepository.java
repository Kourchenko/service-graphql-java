package com.kourchenko.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kourchenko.graphql.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, String> {}