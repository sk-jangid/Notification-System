package com.Amazon.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class communicationMethods {
	
	
	/*public communicationMethods(JSONObject communicationMethods) {
		super();
		this.communicationMethods = communicationMethods;
	}*/
	public JSONArray getCummunicationMethods(String event)  {
			JSONObject communicationMethods=null;
			return  (JSONArray) communicationMethods.get(event);			
	}		
	

}
