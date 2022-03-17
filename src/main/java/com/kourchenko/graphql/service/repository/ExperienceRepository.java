package com.kourchenko.graphql.service.repository;

import java.util.List;
import com.kourchenko.graphql.dao.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    public List<Experience> findAllByResumeId(int resumeId);

}
