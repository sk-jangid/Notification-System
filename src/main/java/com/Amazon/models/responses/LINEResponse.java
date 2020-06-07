package com.Amazon.models.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.NonNull;

@JsonInclude(Include.NON_NULL)
public class LINEResponse {
	
	@NonNull
	String status;
	String message;
	String retryKey;
	public LINEResponse(@NonNull String status) {
		super();
		this.status = status;
		this.message=null;
		//this.message=message;
	}
	public LINEResponse(@NonNull String status,String message,String retryKey) {
		super();
		this.status = status;
		this.message=message;
		this.retryKey=retryKey;
		
		//this.message=message;
	}
	public LINEResponse(@NonNull String status,String message) {
		super();
		this.status = status;
		this.message=message;
		this.retryKey=null;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRetryKey() {
		return retryKey;
	}
	public void setRetryKey(String retryKey) {
		this.retryKey = retryKey;
	}

	

}
