package com.Amazon.models.responses;

import com.Amazon.models.responses.LINEResponse.LINEResponseBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NonNull;
import lombok.Value;
@Value
@Builder
@JsonDeserialize(builder = LINEResponseBuilder.class)
@JsonInclude(Include.NON_NULL)
public class LINEResponse {
	
	 @JsonPOJOBuilder(withPrefix = "")
	    public static class LINEResponseBuilder {
	        // filled by lombok.
	    }
	@NonNull
	boolean isSuccessful;
	String message;

	public LINEResponse(@NonNull boolean isSuccessful) {
		super();
		this.isSuccessful = isSuccessful;
		this.message=null;
		//this.message=message;
	}
	public LINEResponse(@NonNull boolean isSuccessful,String message) {
		super();
		this.isSuccessful = isSuccessful;
		this.message=message;
		//this.message=message;
	}
	public LINEResponse() {
		super();
	}

	public boolean getIsSuccessful() {
		return isSuccessful;
	}

	public void setIsSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	

}
