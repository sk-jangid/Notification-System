package com.Amazon.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.Message.Message;
import com.Amazon.models.Message.textMessage;
import com.Amazon.models.responses.LINEResponse;
import com.Amazon.services.sendMessage.sendService;

import lombok.AllArgsConstructor;



// Service to initiate the process of Message Sending by generating the Message from text
@Service
@AllArgsConstructor
public class LINEMessageClient {
	
	private final sendService LINEClient;

	public LINEMessageClient(sendService lineClient) {
		this.LINEClient=lineClient;
	}

	public LINEResponse sendMessage(List<String> message,String to,String retryKey) throws IOException, InterruptedException, ExecutionException  {
		
		// Message type is text
		List<Message> textMessage=new ArrayList<>();
		/*
		 * Max Limit is to send 5 Messages
		 */
		for(int i=0;i<message.size();i++) {
			textMessage.add(new textMessage(message.get(i)));
			
		}
		
		LINEMessage APIMessage=new LINEMessage(to,textMessage);
		
		int  Response=LINEClient.send(APIMessage,retryKey);
		switch(Response) {
			// send Response According to the Response Received from LINE API
			case(200): return new LINEResponse("OK");
			case(400): return new LINEResponse("failed","Unauthorized customer.LINE Id not valid for the Customer");
			case(401): return new LINEResponse("failed","Some Error on the server. try again");
			case(403): return new LINEResponse("failed","Internal Error");
			case(409): return new LINEResponse("OK");
			case(429): return new LINEResponse("failed","Can not Proceed now.Try after some time");
			case(500): return new LINEResponse("failed","Error with LINE platform",retryKey);
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
