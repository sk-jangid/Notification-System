package com.Amazon.services;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import com.Amazon.models.useCases.usecase;


// Service to generate Message from templates

@Service
public class messageGenerator {



	public static String generate(usecase input, org.json.JSONObject customerInformation) throws ParseException {
		
		
		// template is the JSONObject to get template of that Message
		org.json.JSONObject template = null;
		// Get the template Message file
		try {
			template = FileAbstractHandler.getJSONObjectFromFile("src\\main\\Abstracts\\LINE\\"+input.getEvent()+".json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Format the Message According to the Message templates
		MessageFormat formatter = new MessageFormat(template.getString("message"), Locale.UK);
		org.json.JSONArray messageTemplateVariables=template.getJSONArray("variables");
		Object[] data = new Object[messageTemplateVariables.length()] ;
		String variable="";
		 for(int i=0; i < messageTemplateVariables.length(); i++) {
			variable=messageTemplateVariables.getString(i);
			//System.out.println(messageTemplateVariables.getString(i));
			if(customerInformation.has(variable)) {
			data[i]=(customerInformation.getString(messageTemplateVariables.getString(i)));
			}else if(input.getEventDetails().has(variable)){
				data[i]=(input.getEventDetails().getString(messageTemplateVariables.getString(i)));
			}else {
				return "error";
			}
	      }
		 
		 // return generated Message
		 String message = formatter.format(data);
		
		return message;
	}
}
