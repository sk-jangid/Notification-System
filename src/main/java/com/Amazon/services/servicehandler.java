package com.Amazon.services;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.Amazon.models.responses.LINEResponse;
import com.Amazon.models.useCases.usecase;
import com.fasterxml.uuid.Generators;

import lombok.AllArgsConstructor;

// Service to handle all requests
@Service
@AllArgsConstructor
public class servicehandler {
	// currently only handling LINE users
	LINEMessageClient client;
	messageGenerator getMessage;
	public servicehandler(LINEMessageClient lineMessageClient,messageGenerator getMessage) {
		this.client=lineMessageClient;
		this.getMessage=getMessage;
	}
	
	public  LINEResponse execute(usecase input) throws JSONException, IOException, InterruptedException, ExecutionException, ParseException  {
		org.json.JSONObject customerInformation = customerDetails.getCustomrDetails(input.getCustomerId());
		
		// Generate a Message for the LINE Users
		List<String> message = getMessage.generate(input,customerInformation);
		if(message.isEmpty()) {
			return new LINEResponse("failed","Bad Request");
		}
		String retryKey="";
		if(input.getEventDetails().has("LINE-retry-key")) {
			retryKey=input.getEventDetails().getString("LINE-retry-key");
		}else {
			retryKey=Generators.timeBasedGenerator().generate().toString();
		}
		return client.sendMessage(message,customerInformation.getJSONObject("LINE").getString("UserId"),retryKey);
	}
	

}
