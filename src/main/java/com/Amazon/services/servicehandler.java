package com.Amazon.services;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.Amazon.models.responses.LINEResponse;
import com.Amazon.models.useCases.usecase;
import com.Amazon.services.clients.client;
import com.Amazon.services.clients.clientConfiguration;

import lombok.AllArgsConstructor;

// Service to handle all requests
@Service
@AllArgsConstructor
public class servicehandler {
		
	public  LINEResponse execute(usecase input) throws ParseException, IOException, InterruptedException, ExecutionException   {
		JSONObject customerInformation = customerDetails.getCustomrDetails(input.getCustomerId());
		JSONArray commMethods=communicationMethods.getCummunicationMethods(input.getEvent());
		LINEResponse response=null;
		client messageClient=null;
		for(int i=0;i<commMethods.length();i++) {
			messageClient=clientConfiguration.retrieveClient(commMethods.getString(i));
			if(messageClient!=null) {
				response=messageClient.sendMessage(input.getEvent(),customerInformation,input.getEventDetails());
			}
			
			
		}
		return response;
	}
	

}
