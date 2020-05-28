package com.Amazon.models.error;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;


// Created for responding to the errors currently no use till now
@Value
public class ErrorDetail {
    
    public String message;
    public String property;
    public ErrorDetail(
            @JsonProperty("message") String message,
            @JsonProperty("property") String property) {
        this.message = message;
        this.property = property;
    }
   public  String getMessage() {
    	return message;
    }
    public String getProperty() {
    	return property;
    }
}
