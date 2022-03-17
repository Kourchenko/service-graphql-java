package com.kourchenko.graphql.service.repository;

import java.util.List;
import com.kourchenko.graphql.dao.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

    public List<Education> findAllByResumeId(int resumeId);
}
