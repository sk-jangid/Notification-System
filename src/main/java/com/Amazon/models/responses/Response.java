package com.Amazon.models.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
	
	
	LINEResponse LINE;
	String message;
	public Response() {
		super();
	}

	public LINEResponse getLINE() {
		return LINE;
	}
	public void add(LINEResponse lINE) {
		this.LINE = lINE;
	}
	public String getMessage() {
		return message;
	}
	public void add(String message) {
		this.message = message;
	}
	
	
}
