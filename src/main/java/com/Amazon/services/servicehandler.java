package com.Amazon.services;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.Amazon.models.responses.LINEResponse;
import com.Amazon.models.useCases.usecase;
import com.fasterxml.uuid.Generators;
//import com.Amazon.services.sendMessage.responseBody;
// Service to handle all requests
@Service
public class servicehandler {
	// currently only handling LINE users
	LINEMessageClient client;
	//communicationMethods commMethod;
	
	public servicehandler(LINEMessageClient lineMessageClient) {
		this.client=lineMessageClient;
		//this.commMethod=communicationMethods;
	}

	public  LINEResponse execute(usecase input) throws JSONException, IOException, InterruptedException, ExecutionException, ParseException  {
		org.json.JSONObject customerInformation = customerDetails.getCustomrDetails(input.getCustomerId());
		
		//Communication Methods in JSON Array for which event is to be communicated
		//JSONArray methodOfCommunication = commMethod.getCummunicationMethods(input.getEvent());
		
		// Generate a Message for the LINE Users
		List<String> message = Collections.singletonList(messageGenerator.generate(input,customerInformation));
		String retryKey="";
		if(input.getEventDetails().has("LINE-retry-key")) {
			retryKey=input.getEventDetails().getString("LINE-retry-key");
		}else {
			retryKey=Generators.timeBasedGenerator().generate().toString();
		}
		return client.sendMessage(message,customerInformation.getJSONObject("LINE").getString("UserId"),retryKey);
	}
	

}
