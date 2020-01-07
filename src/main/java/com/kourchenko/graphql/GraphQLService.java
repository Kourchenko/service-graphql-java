package com.kourchenko.graphql;

import com.kourchenko.graphql.datafetcher.AllWorkExperienceDataFetcher;
import com.kourchenko.model.WorkExperience;
import com.kourchenko.repository.WorkExperienceRepository;

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
    private WorkExperienceRepository workExperienceRepository;

    private AllWorkExperienceDataFetcher allWorkExperienceDataFetcher;

    @Value("classpath:schema/workexperience.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    public GraphQLService(WorkExperienceRepository workExperienceRepository, AllWorkExperienceDataFetcher allWorkExperienceDataFetcher) {
        this.workExperienceRepository = workExperienceRepository;
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
                .dataFetcher("allWorkExperience", allWorkExperienceDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}

