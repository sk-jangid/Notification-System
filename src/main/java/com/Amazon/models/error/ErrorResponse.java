
package com.Amazon.models.error;

import java.util.Collections;
import java.util.List;

import com.Amazon.services.sendMessage.ApiResponse.ApiResponseBuilder;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;
import com.Amazon.models.error.ErrorResponse.ErrorResponseBuilder;
@Value
@Builder
//@JsonDeserialize(builder = ErrorResponseBuilder.class)
public class ErrorResponse {
	
	
	
	@JsonPOJOBuilder(withPrefix = "")
	public static class ErrorResponseBuilder {
	        // filled by lombok.
	}
	    
    String requestId;
    String message;
    List<ErrorDetail> details;
    public ErrorResponse(//String requestId,String message,List<ErrorDetail> details) {
            @JacksonInject("requestId") final String requestId,
            @JsonProperty("message") final String message,
            @JsonProperty("details") final List<ErrorDetail> details) {
        //this.requestId = requestId;
    	super();
    	this.requestId = requestId;
        this.message = message;
        this.details = details != null ? details : Collections.emptyList();
    }
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ErrorDetail> getDetails() {
		return details;
	}
	public void setDetails(List<ErrorDetail> details) {
		this.details = details;
	}
	public ErrorResponse() {
		super();
	}
    
	/*public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	public List<ErrorDetail> getDetails() {
		// TODO Auto-generated method stub
		return details;
	}*/
}
