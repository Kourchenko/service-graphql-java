package com.kourchenko.graphql.service.repository;

import com.kourchenko.graphql.dao.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
