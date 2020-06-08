package com.Amazon.services;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.Amazon.models.responses.Response;
import com.Amazon.models.useCases.usecase;
import com.Amazon.services.clients.client;
import com.Amazon.services.clients.clientConfiguration;

import lombok.AllArgsConstructor;

// Service to handle all requests
@Service
@AllArgsConstructor
public class servicehandler {
	 
	static messageGenerator getMessage=new messageGenerator();
	JSONObject customerInformation;
	JSONArray commMethods;
	List<String> message;
	public  Response execute(usecase input) throws ParseException, IOException, InterruptedException, ExecutionException   {
		Response response=new Response();
		
		customerInformation = customerDetails.getCustomrDetails(input.getCustomerId());
		if(customerInformation==null) {
			response.add("Unidentified Customer");
			return response;
		}
		commMethods=communicationMethods.getCummunicationMethods(input.getEvent());
		if(commMethods==null) {
			response.add(input.getEvent()+ " event is currently Not supported in the Service");
			return response;
		}
		client messageClient=null;
		for(int i=0;i<commMethods.length();i++) {
			messageClient=clientConfiguration.retrieveClient(commMethods.getString(i));
			
			if(messageClient!=null) {
				message=getMessage.generate(input.getEventDetails(),customerInformation,commMethods.getString(i),input.getEvent());
				response.add(messageClient.sendMessage(message,customerInformation,input.getEventDetails()));
			}
			
			
		}
		return response;
	}
	

}
