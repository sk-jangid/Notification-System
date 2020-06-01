package com.Amazon.services;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


//Service to read a JSON file and return the JSON object
@Service
public class FileAbstractHandler {
	static JSONObject getJSONObjectFromFile(String path) throws JsonParseException, JsonMappingException, IOException, ParseException {
	
		//create a Parser to Parse a file
		JSONParser parser = new JSONParser(new FileReader(path));
		 System.out.println("skj");
		 try {
	         Object obj = parser.parse();
	         @SuppressWarnings("unchecked")
	        
	         HashMap<String, String> jsonObject = (HashMap<String, String>)obj;
	         JSONObject json = new JSONObject(jsonObject);
	         //return the Object of the JSON Object got from File
	         return json;
	      } catch(Exception e) {
	    	  	
	         e.printStackTrace();
	      }
		 return null;	
	}	
	

}
