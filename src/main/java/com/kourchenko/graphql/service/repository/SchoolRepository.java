package com.kourchenko.graphql.service.repository;

import java.util.List;
import com.kourchenko.graphql.dao.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    List<School> findAllByEducationId(int educationId);
}
