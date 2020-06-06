package com.Amazon.services.clients;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;

import com.Amazon.models.responses.LINEResponse;

public interface client {

	LINEResponse sendMessage(String event, JSONObject customerInformation, JSONObject eventDetails) throws ParseException;

		
}
