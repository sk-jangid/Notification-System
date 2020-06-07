package com.Amazon.services.clients;

import java.util.List;

import org.json.JSONObject;

import com.Amazon.models.responses.LINEResponse;

public interface client {

	LINEResponse sendMessage(List<String> message,JSONObject customerInformation, JSONObject eventDetails);

		
}
