package com.Amazon.services;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.useCases.usecase;
// Service to handle all requests
@Service
public class servicehandler {
	// currently only handling LINE users
	
	public static LINEMessage execute(usecase input) throws ParseException, IOException {
		org.json.JSONObject customerInformation = customerDetails.getCustomrDetails(input.getCustomerId());
		
		//Communication Methods in JSON Array for which event is to be communicated
		JSONArray methodOfCommunication = communicationMethods.getCummunicationMethods(input.getEvent());
		
		// Generate a Message for the LINE Users
		String message = messageGenerator.generate(input,customerInformation);
		
		// call the Service to send Message 
		return LINEMessageClient.sendMessage(message,customerInformation.getJSONObject("LINE").getString("UserId"));
	}
	

}
