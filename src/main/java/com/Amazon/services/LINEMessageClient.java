package com.Amazon.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.Message.Message;
import com.Amazon.models.Message.textMessage;
import com.Amazon.models.responses.LINEResponse;
import com.Amazon.services.sendMessage.LINEClient;
import com.Amazon.services.sendMessage.sendService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;



// Service to initiate the process of Message Sending by generating the Message from text
//@Service
@AllArgsConstructor
@Slf4j
public class LINEMessageClient {

	private final  sendService LINEClient;

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
		//sendService s=new LINEClient().channelAccessToken("MEGhysNQpGvlM3aMs+g9FaQJcOA0oDD2zKxbUU6O933/QTqiB0zBITtUyjjVHSDY42CD76e/0BjibGyZR5iYZynmbcX042lQqy7eP2YApioEFfTExQypkuGECIZ4ayba54Y9PaTrCOIvRbvixAdeoQdB04t89/1O/w1cDnyilFU=").build();
		int  Response=LINEClient.send(APIMessage,retryKey);
		System.out.println(Response);
		switch(Response) {
			case(200): return new LINEResponse(true);
			case(400): return new LINEResponse(false,"Unauthorized customer.LINE Id not valid for the Customer",retryKey);
			case(401): return null;
			case(403): return new LINEResponse(false,"Unauthorized customer. LINE Id not valid for the Customer",retryKey);
			case(409): return new LINEResponse(true);
			case(429): return null;
			case(500): return null;
			case(501): 
				int retryResponse=LINEClient.send(APIMessage, retryKey);
				System.out.println("yes");
				if(retryResponse==409||retryResponse==200) {
					
					return new LINEResponse(true);
				}else {
					return new LINEResponse(false,"can not proceed request right now",retryKey);
				}
		
				
		
		
		}
		
		
		
		return null;
	
	
		
	}

}
