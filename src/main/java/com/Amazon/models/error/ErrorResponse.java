
package com.Amazon.models.error;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;


@Value
public class ErrorResponse {
    String requestId;
    String message;
    List<ErrorDetail> details;
    public ErrorResponse(
            @JacksonInject("requestId") final String requestId,
            @JsonProperty("message") final String message,
            @JsonProperty("details") final List<ErrorDetail> details) {
        this.requestId = requestId;
        this.message = message;
        this.details = details != null ? details : Collections.emptyList();
    }
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
