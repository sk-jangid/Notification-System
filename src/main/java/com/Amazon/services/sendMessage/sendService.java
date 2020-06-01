package com.Amazon.services.sendMessage;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.catalina.startup.Tomcat;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;
//import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.error.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.uuid.Generators;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/*
 * Service to send the Actual Message
 * Currently Not Working for Push
 */
//@Service
@Slf4j
@AllArgsConstructor
//@Component
public class sendService  {
	//static final ExceptionConverter EXCEPTION_CONVERTER = new ExceptionConverter();
	private final  messagesend service;
	//private final retryKey;
	int responseCode;
	public sendService(messagesend ser) {
		super();
		this.service = ser;
	}

	// Method to send Message
	public int send(LINEMessage message,String retryKey)   {
		//responseCode=500;
		//String retryKey = Generators.timeBasedGenerator().generate().toString();
	    Call<responseBody> retrofitCall = service.pushMessage(message,retryKey);
	    
	    try {  
		    Response<responseBody> response = retrofitCall.execute();
			   System.out.println(response.body());

		    if(response.isSuccessful()) {
		    //response.wait(20000);
		    responseCode=response.code();
		    }
		    else {
		    	System.out.println("skj");
		    	responseCode=response.code();
		    }
	    } catch (IOException e) {
	    	responseCode=501;
	    }
	 
		return responseCode;
	    
	 }

	
	 
	
}
