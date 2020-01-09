package com.kourchenko.graphql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kourchenko.repository.ResumeRepository;
import com.kourchenko.model.Resume;

@Component
public class ResumeDataFetcher implements DataFetcher<Resume> {
    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeDataFetcher(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public Resume get(DataFetchingEnvironment dataFetchingEnvironment) {
        return resumeRepository.findById("0001").orElse(null);
    }
}