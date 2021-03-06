package com.kourchenko.graphql;

import com.kourchenko.graphql.datafetcher.AllWorkExperienceDataFetcher;
import com.kourchenko.graphql.datafetcher.ResumeDataFetcher;
import com.kourchenko.graphql.model.WorkExperience;
import com.kourchenko.graphql.repository.ResumeRepository;
import com.kourchenko.graphql.repository.WorkExperienceRepository;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.RuntimeWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class GraphQLService {
    private ResumeRepository resumeRepository;

    private ResumeDataFetcher resumeDataFetcher;

    private AllWorkExperienceDataFetcher allWorkExperienceDataFetcher;

    @Value("classpath:graohql/schema.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    public GraphQLService(
            ResumeRepository resumeRepository, 
            ResumeDataFetcher resumeDataFetcher,
            AllWorkExperienceDataFetcher allWorkExperienceDataFetcher) {
        this.resumeRepository = resumeRepository;
        this.resumeDataFetcher = resumeDataFetcher;
        this.allWorkExperienceDataFetcher = allWorkExperienceDataFetcher;
    }

    @PostConstruct
    private void loadSchema() throws IOException {
        File file = resource.getFile();

        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
            .type("Query", typeWiring -> typeWiring
                .dataFetcher("resume", resumeDataFetcher)
                .dataFetcher("allWorkExperience", allWorkExperienceDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}

