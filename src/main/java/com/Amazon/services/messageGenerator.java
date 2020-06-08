package com.Amazon.services;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;


// Service to generate Message from templates

@Service
@NoArgsConstructor
public class messageGenerator {

	
	static String LINEpaymentDue="src\\main\\Abstracts\\LINE\\paymentDue.json";
	static String LINEorderStatus="src\\main\\Abstracts\\LINE\\orderStatus.json";
	static String LINEorderCancelled="src\\main\\Abstracts\\LINE\\orderCancelled.json";
	String path;
	static Map<String, String> messageTemplateMap = new HashMap<>();
    static {
    	messageTemplateMap.put("LINEpaymentDue",LINEpaymentDue);
    	messageTemplateMap.put("LINEorderStatus",LINEorderStatus);
    	messageTemplateMap.put("LINEorderCancelled",LINEorderCancelled);
        //operationMap.put("Alexa", alexaClient);
  
    }

	//public static client retrieveClient(String client) {
       
    //}
	

	public List<String> generate(JSONObject eventDetails ,JSONObject customerInformation,String commMethod,String eventType) throws ParseException {
		
		
		// template is the JSONObject to get template of that Message
		JSONObject template = null;
		//path="";
		path= messageTemplateMap.get(commMethod+eventType);
		if(path==null) {
			//System.out.println(commMethod+eventType);
			return Collections.emptyList();
		}
		try {
			//System.out.println(path);
			template = FileAbstractHandler.getJSONObjectFromFile(path);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
			
		}
		
		//Format the Message According to the Message templates
		MessageFormat formatter = new MessageFormat(template.getString("message"), Locale.UK);
		JSONArray messageTemplateVariables=template.getJSONArray("variables");
		Object[] data = new Object[messageTemplateVariables.length()] ;
		String variable="";
		 for(int i=0; i < messageTemplateVariables.length(); i++) {
			variable=messageTemplateVariables.getString(i);
			
			if(customerInformation.has(variable)) {
			data[i]=(customerInformation.getString(messageTemplateVariables.getString(i)));
			
			}else if(eventDetails.has(variable)){
				data[i]=(eventDetails.getString(messageTemplateVariables.getString(i)));
				
			}else {
				// error with the Request some fields that are to be changed are missing in input Request
				return Collections.emptyList();
			}
	      }
		 
		 // return generated Message
		 String message = formatter.format(data);
		
		return Collections.singletonList(message);
	}
}
