package com.kourchenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kourchenko.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, String> {}