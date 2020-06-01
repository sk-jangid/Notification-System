package com.Amazon.controller;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amazon.models.error.ErrorResponse;
import com.Amazon.models.responses.LINEResponse;
import com.Amazon.models.useCases.usecase;
import com.Amazon.services.servicehandler;
import com.Amazon.services.sendMessage.ApiResponse;
@RestController
@RequestMapping
public class useCaseController {
	@Autowired
	servicehandler service;
	
	@PostMapping(value="notificationService")
	public LINEResponse controller(@RequestBody String input) throws ParseException, IOException, JSONException, InterruptedException, ExecutionException   {
		 // Currently taking a string as input and then converting it to object of class useCase
		
		
		JSONObject inputInJSON = new JSONObject(input);
		JSONObject eventDetails=inputInJSON.getJSONObject("eventDetails");
		
		String event=inputInJSON.getString("event");
		String customerId=inputInJSON.getString("customerId");
		usecase inputConvertedToObject= new usecase(event,customerId,eventDetails);
     
		// execute service to send the Message
		//System.out.println(s);
		return  service.execute(inputConvertedToObject);
		//return null;
		
	}
	
	
	
	
	
	
	

}
