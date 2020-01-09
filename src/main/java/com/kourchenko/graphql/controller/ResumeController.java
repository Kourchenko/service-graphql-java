package com.kourchenko.graphql.controller;

import com.kourchenko.graphql.GraphQLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RequestMapping("/graphql/resume")
@RestController
public class ResumeController {
    private GraphQLService graphQLService;

    @Autowired
    public ResumeController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ResponseEntity<Object> getResume() {
        String query = "query { resume { firstName, lastName } }";
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}