package com.techshard.graphql.exception;

import java.util.List;
import java.util.stream.Collectors;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;

public class GraphQLErrorHandler  implements graphql.servlet.GraphQLErrorHandler{

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> list) {
		return list.stream().map(this::getNested).collect(Collectors.toList());
    }

    private GraphQLError getNested(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof GraphQLError) {
                return (GraphQLError) exceptionError.getException();
            }
        }
        return error;
    }
}
