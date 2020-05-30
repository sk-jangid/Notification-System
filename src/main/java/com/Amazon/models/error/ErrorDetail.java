package com.Amazon.models.error;



import com.Amazon.models.error.ErrorResponse.ErrorResponseBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;
import com.Amazon.models.error.ErrorDetail.ErrorDetailBuilder;


// Created for responding to the errors currently no use till now
@Value
@Builder
//@JsonDeserialize(builder = ErrorDetailBuilder.class)
public class ErrorDetail {
    
	@JsonPOJOBuilder(withPrefix = "")
	public static class ErrorDetailBuilder {
	        // filled by lombok.
	}
    public String message;
    public String property;
    public ErrorDetail(
            @JsonProperty("message") String message,
            @JsonProperty("property") String property) {
        this.message = message;
        this.property = property;
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public ErrorDetail() {
		super();
	}
    
    
 /*  public  String getMessage() {
    	return message;
    }
    public String getProperty() {
    	return property;
    }*/
}
