package com.Amazon.models.responses;

//import com.Amazon.models.responses.LINEResponse.LINEResponseBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.NonNull;
import lombok.Value;
@Value
//@Builder
//@JsonDeserialize(builder = LINEResponseBuilder.class)
@JsonInclude(Include.NON_NULL)
public class LINEResponse {
	
	
	@NonNull
	boolean isSuccessful;
	String message;
	String retryKey;
	public LINEResponse(@NonNull boolean isSuccessful) {
		super();
		this.isSuccessful = isSuccessful;
		this.message=null;
		//this.message=message;
	}
	public LINEResponse(@NonNull boolean isSuccessful,String message,String retryKey) {
		super();
		this.isSuccessful = isSuccessful;
		this.message=message;
		this.retryKey=retryKey;
		
		//this.message=message;
	}
	public String getRetryKey() {
		return retryKey;
	}
	public void setRetryKey(String retryKey) {
		this.retryKey = retryKey;
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
