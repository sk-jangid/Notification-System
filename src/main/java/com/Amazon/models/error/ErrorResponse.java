
package com.Amazon.models.error;

import static java.util.Collections.emptyList;

import java.util.Collections;
import java.util.List;

import com.Amazon.models.error.ErrorResponse.ErrorResponseBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;
//@Data

/* 
 * 
Not Necessary With respect to this Project right Now 
 *
*/
@Value
@Builder
@JsonDeserialize(builder = ErrorResponseBuilder.class)
public class ErrorResponse {
	//String requestId;
	@JsonPOJOBuilder(withPrefix = "")
    public static class ErrorResponseBuilder {
        // filled by lombok.
    }
    String message;
    @Default
    List<ErrorDetail> details=emptyList();
    public ErrorResponse(
            //@JacksonInject("requestId") final String requestId,
            @JsonProperty("message") final String message,
            @JsonProperty("details") final List<ErrorDetail> details) {
    	super();
    	//this.requestId = requestId;
        this.message = message;
        this.details = details != null ? details : Collections.emptyList();
    }
	
    
	
}
