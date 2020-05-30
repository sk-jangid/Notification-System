package com.Amazon.services.sendMessage;

import static java.util.Collections.emptyList;

import java.util.List;

import com.Amazon.models.error.ErrorDetail;
import com.Amazon.services.sendMessage.responseBody.responseBodyBuilder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

//import com.Amazon.model.response.BotApiResponse;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;


/*
 * Response Body for responses of API
 */
@Value
@Builder
@JsonDeserialize(builder = responseBodyBuilder.class)
class responseBody {
    @JsonPOJOBuilder(withPrefix = "")
    public static class responseBodyBuilder {
        // filled by lombok.
    }

    String message;
    @Default
    List<ErrorDetail> details = emptyList();

   public responseBody(String message,List<ErrorDetail> details) {
		super();
		this.message = message;
		this.details = details;
	}
  
   

	
	
}
