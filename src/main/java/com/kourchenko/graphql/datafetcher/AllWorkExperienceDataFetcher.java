package com.kourchenko.graphql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import com.kourchenko.graphql.repository.WorkExperienceRepository;
import com.kourchenko.graphql.model.WorkExperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllWorkExperienceDataFetcher implements DataFetcher<List<WorkExperience>> {
    private WorkExperienceRepository workExperienceRepository;

    @Autowired
    public AllWorkExperienceDataFetcher(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    @Override
    public List<WorkExperience> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return workExperienceRepository.findAll();
    }

}