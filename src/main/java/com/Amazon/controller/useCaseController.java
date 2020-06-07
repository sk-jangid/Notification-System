package com.Amazon.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amazon.models.responses.Response;
import com.Amazon.models.useCases.usecase;
import com.Amazon.services.servicehandler;
@RestController
@RequestMapping
public class useCaseController {
	@Autowired
	servicehandler service;
	Response response;
	@PostMapping(value="notificationService")
	public Response controller(@RequestBody String input,HttpServletResponse responseStatus) throws ParseException, IOException, JSONException, InterruptedException, ExecutionException   {
		 // Currently taking a string as input and then converting it to object of class useCase
		
		JSONObject inputInJSON = new JSONObject(input);
		JSONObject eventDetails=inputInJSON.getJSONObject("eventDetails");
		response=null;
		String event=inputInJSON.getString("event");
		String customerId=inputInJSON.getString("customerId");
		usecase inputConvertedToObject= new usecase(event,customerId,eventDetails);
     
		// execute service to send the Message
		
		response= service.execute(inputConvertedToObject);
		if(response.getMessage()==null) {
			responseStatus.setStatus(HttpServletResponse.SC_OK);
		}else if(response!=null) {
			responseStatus.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}else {
			responseStatus.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);	
		}
		return response;
		
	}
	
	
	
	
	
	
	

}
