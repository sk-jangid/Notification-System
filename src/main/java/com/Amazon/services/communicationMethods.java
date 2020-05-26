package com.Amazon.services;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class communicationMethods {
	
	static JSONArray getCummunicationMethods(String event) throws ParseException {
		
		org.json.JSONObject communicationMethods = null;
		try {
			communicationMethods = FileAbstractHandler.getJSONObjectFromFile("src\\main\\Abstracts\\communicationMethods.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  (JSONArray) communicationMethods.get(event);
		
		
	}		
	

}
