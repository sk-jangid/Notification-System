package com.Amazon.services.clients;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.Message.Message;
import com.Amazon.models.Message.textMessage;
import com.Amazon.models.responses.LINEResponse;
import com.Amazon.services.clients.LINEClient.sendServiceBuilder;
import com.Amazon.services.clients.LINEClient.sendServiceWorking;
import com.fasterxml.uuid.Generators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



// Service to initiate the process of Message Sending by generating the Message from text
@Service
@AllArgsConstructor
@NoArgsConstructor
public class LINEMessageClient implements client{
	
	//private final sendService LINEClient;
	static sendServiceWorking LINEClient=new sendServiceBuilder().build();
	
	
	
	@Override
	public LINEResponse sendMessage(List<String>message,JSONObject customerDetails,JSONObject eventDetails)   {
		
		// Message type is text
		List<Message> textMessage=new ArrayList<>();
		/*
		 * Max Limit is to send 5 Messages
		 */
		
		if(message.isEmpty()) {
			return new LINEResponse("failed","Bad Request with some input Missing in event-details");
		}
		
		
		for(int i=0;i<message.size();i++) {
			textMessage.add(new textMessage(message.get(i)));
			
		}
	
		
		
		String to=((JSONObject) customerDetails.get("LINE")).getString("UserId");
		LINEMessage APIMessage=new LINEMessage(to,textMessage);
			
		String retryKey="";
		if(eventDetails.has("LINE-retry-key")) {
			retryKey=eventDetails.getString("LINE-retry-key");
		}else {
			retryKey=Generators.timeBasedGenerator().generate().toString();
		}
		
		int  Response=LINEClient.send(APIMessage,retryKey);
		switch(Response) {
			// send Response According to the Response Received from LINE API
			case(200): return new LINEResponse("OK");
			case(400): return new LINEResponse("failed","Unauthorized customer.LINE Id not valid for the Customer");
			case(401): return new LINEResponse("failed","Some Error on the server. try again");
			case(403): return new LINEResponse("failed","Internal Error with Service");
			case(409): return new LINEResponse("OK");
			case(429): return new LINEResponse("failed","Can not Proceed now.Try after some time");
			case(500): return new LINEResponse("can't say","Error with LINE platform",retryKey);
			case(501): 
				int retryResponse=LINEClient.send(APIMessage, retryKey);
				// 409 for conflict and 200 for re-sending request
				if(retryResponse==409||retryResponse==200) {
					
					return new LINEResponse("OK");
				}else {
					return new LINEResponse("failed","can not proceed request right now",retryKey);
				}
				
		}
		
		
		
		return null;
	
	
		
	}

}
