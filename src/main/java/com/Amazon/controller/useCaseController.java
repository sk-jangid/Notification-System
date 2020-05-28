package com.Amazon.controller;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amazon.models.useCases.usecase;
import com.Amazon.services.servicehandler;
import com.Amazon.services.sendMessage.responseBody;

import retrofit2.Response;
@RestController
@RequestMapping
public class useCaseController {
	
	
	@PostMapping(value="notificationService")
	public Response<responseBody> controller(@RequestBody String input) throws ParseException, IOException   {
		 // Currently taking a string as input and then converting it to object of class useCase
		
		
		JSONObject inputInJSON = new JSONObject(input);
		JSONObject eventDetails=inputInJSON.getJSONObject("eventDetails");
		
		String event=inputInJSON.getString("event");
		String customerId=inputInJSON.getString("customerId");
		usecase inputConvertedToObject= new usecase(event,customerId,eventDetails);
     
		// execute service to send the Message
		return  servicehandler.execute(inputConvertedToObject);
		
	}
	
	
	
	
	
	
	

}
