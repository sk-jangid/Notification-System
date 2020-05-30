package com.Amazon.services.sendMessage;

import java.util.List;

import com.Amazon.services.sendMessage.ApiResponse.ApiResponseBuilder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

// Interface to the API Response
@Value
@Builder
@JsonDeserialize(builder = ApiResponseBuilder.class)
public class ApiResponse {
	@JsonPOJOBuilder(withPrefix = "")
    public static class ApiResponseBuilder {
        // filled by lombok.
    }
    
	String requestId;
    String message;
    List<String> details;
	public ApiResponse(String requestId, String message, List<String> details) {
		super();
		this.requestId = requestId;
		this.message = message;
		this.details = details;
	}
    
}
