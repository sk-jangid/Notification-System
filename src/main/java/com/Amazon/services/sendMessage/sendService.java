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

	public sendService() { 
	       // this.accessToken = "token " + System.getenv("ACCESS_TOKEN");
	    }
	// Method to send Message
	 public static LINEMessage send(LINEMessage message) throws IOException {
		 Retrofit retrofit = new Retrofit.Builder()
	        		.baseUrl(API_BASE_URL)
	        		.addConverterFactory(GsonConverterFactory.create())
	        		.build();
		 
		 //messagesend is the service which has all GET and POST methods
		// call the API to Push Message
	     messagesend ser = retrofit.create(messagesend.class);
	     //Call<responseBody> retrofitCall = ser.pushMessage(message);
	     
	     // call the API to get Message Quota
	     Call<MessageQuotaResponse> retrofitCall=ser.getMessageQuota();
	     
	     //Get a response after executing request
	     Response<MessageQuotaResponse> response = retrofitCall.execute();
	     
	     /*
	      if (!response.isSuccessful()) {
	           throw new IOException(response.errorBody() != null
	                    ? response.errorBody().string() : "Unknown error");
	      }*/
	       
	      //System.out.println(API_BASE_URL);
	      System.out.println( response.code()+"  "+response.isSuccessful());	
	      return message;		
	    }
	 
	 
	
}
