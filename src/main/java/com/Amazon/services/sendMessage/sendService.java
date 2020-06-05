package com.Amazon.services.sendMessage;

import java.io.IOException;

import com.Amazon.models.LINEMessage;

import retrofit2.Call;
import retrofit2.Response;
/*
 * Service to send the Actual Message
 * make Synchronise Requests
 */

public class sendService  {
	private final  messagesend service;
	public int responseCode=0;	

	public sendService(messagesend buildRetrofitInterface) {
		this.service=buildRetrofitInterface;
	}


	// Method to send Message
	public int send(LINEMessage message,String retryKey)   {
	    Call<responseBody> retrofitCall = service.pushMessage(message,retryKey);
	    
	    try {  
		    Response<responseBody> response = retrofitCall.execute();
		    if(response.isSuccessful()) {
		    	responseCode=response.code();    	
		    }
		    else {
		    	responseCode=response.code();
		    }
	    } catch (IOException e) {
	    	
	    	System.out.println(e);
	    	responseCode=501;
	    }
	    return responseCode;
	    
	 }

	
	 
	
}
