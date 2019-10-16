package com.techshard.graphql.exception;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class VehicleNotFoundException extends RuntimeException implements GraphQLError {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	

	public VehicleNotFoundException(int id) {
		this.id = id;
	}
	
	
	
	 @Override
	    public String getMessage() {
	        return "Vehicle with ID " + id + " could not be found";
	    }

	 @Override
	    @JsonIgnore
	    public StackTraceElement[] getStackTrace() {
	        return super.getStackTrace();
	    }

	    @Override
	    public Map<String, Object> getExtensions() {
	        return Collections.singletonMap("vehicleId", id);
	    }
	    
	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return ErrorType.ValidationError;
	}

	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

}
