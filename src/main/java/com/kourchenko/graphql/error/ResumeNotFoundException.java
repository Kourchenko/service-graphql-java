package com.kourchenko.graphql.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class ResumeNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public ResumeNotFoundException(String message) {
        super(message);
    }

    public ResumeNotFoundException(String message, int id) {
        super(message);
        extensions.put("id", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
