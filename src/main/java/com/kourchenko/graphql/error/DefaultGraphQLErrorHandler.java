package com.kourchenko.graphql.error;

import java.util.List;
import java.util.stream.Collectors;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.execution.NonNullableFieldWasNullError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {

        final List<GraphQLError> clientErrors = filterGraphQLErrors(errors);

        if (clientErrors.size() < errors.size()) {

            // Some errors were filtered out to hide implmenetation - put a generic error in place.
            GenericGraphQLError genericGraphQLError = new GenericGraphQLError(
                    "Sorry, Internal Server Error(s) while executing query");
            clientErrors.add(genericGraphQLError);

            errors.stream().filter(error -> !isClientError(error)).forEach(this::logError);
        }

        return clientErrors;
    }

    protected void logError(GraphQLError error) {
        if (error instanceof Throwable) {
            log.error("Error executing query!", (Throwable) error);
        } else if (error instanceof ExceptionWhileDataFetching) {
            log.error("Error executing query {}", error.getMessage(),
                    ((ExceptionWhileDataFetching) error).getException());
        } else {
            log.error("Error executing query ({}): {}", error.getClass().getSimpleName(),
                    error.getMessage());
        }
    }

    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream().filter(this::isClientError)
                .map(this::replaceNonNullableFieldWasNullError).collect(Collectors.toList());
    }

    protected boolean isClientError(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            return ((ExceptionWhileDataFetching) error).getException() instanceof GraphQLError;
        }

        return true;
    }

    private GraphQLError replaceNonNullableFieldWasNullError(GraphQLError error) {
        if (error instanceof NonNullableFieldWasNullError) {
            return new RenderableNonNullableFieldWasNullError((NonNullableFieldWasNullError) error);
        } else {
            return error;
        }
    }
}
