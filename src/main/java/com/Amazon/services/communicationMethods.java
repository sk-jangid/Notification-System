package com.Amazon.services;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class communicationMethods {
	
	
	/*public communicationMethods(JSONObject communicationMethods) {
		super();
		this.communicationMethods = communicationMethods;
	}*/
	public static JSONArray getCummunicationMethods(String event)  {
			JSONObject communicationMethods=null;
			try {
				communicationMethods = FileAbstractHandler.getJSONObjectFromFile("src\\main\\Abstracts\\communicationMethods.json");
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
			if(communicationMethods.has(event)) {
			return  (JSONArray) communicationMethods.get(event);
			}else {
				return null;
			}
	}		
	

}
