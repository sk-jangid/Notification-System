package com.Amazon.services.sendMessage;

import java.util.List;
import lombok.Value;

// Interface to the API Response
@Value
public class ApiResponse {
    	
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
