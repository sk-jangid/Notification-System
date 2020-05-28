package com.Amazon.services.sendMessage;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/*
 * Service to send the Actual Message
 * Currently Not Working for Push
 */
@Service
public class sendService implements APIConfiguration {
	static final ExceptionConverter EXCEPTION_CONVERTER = new ExceptionConverter();
	public sendService() { 
	       // this.accessToken = "token " + System.getenv("ACCESS_TOKEN");
	    }
	// Method to send Message
	 public static Response<responseBody> send(LINEMessage jsonDataString) throws IOException {
		 
		 Retrofit retrofit = new Retrofit.Builder()
	        		.baseUrl(API_BASE_URL)
	        		.addConverterFactory(GsonConverterFactory.create())
	        		.build();
		 
		 //messagesend is the service which has all GET and POST methods
		// call the API to Push Message
	     messagesend ser = retrofit.create(messagesend.class);
	     Call<responseBody> retrofitCall = ser.pushMessage(jsonDataString);
     
	     //Get a response after executing request
	     Response<responseBody> response = retrofitCall.execute();
	     if(response.isSuccessful()) {
	     }
	     
	     return response;
	    
	 }
	 
	
}
