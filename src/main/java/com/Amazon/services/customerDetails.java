package com.Amazon.services;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

// Service to get customerDetails in a JSON Object

@Service
public class customerDetails {
	
	static JSONObject getCustomrDetails(String customerId) throws ParseException {
		JSONObject customerDetails = null;
		try {
			customerDetails = FileAbstractHandler.getJSONObjectFromFile("src\\main\\Abstracts\\customerDetails.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerDetails.getJSONObject(customerId);
	}

}
