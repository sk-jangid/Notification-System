package com.Amazon.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.Message.Message;
import com.Amazon.models.Message.textMessage;

import com.Amazon.services.sendMessage.sendService;



// Service to initiate the process of Message Sending by generating the Message from text
@Service
public class LINEMessageClient {
	
	static LINEMessage sendMessage(String message,String to) throws IOException  {
		
		// Message type is text
		Message textMessage=new textMessage(message);
		//System.out.println(((textMessage)textMessage).text);
		LINEMessage APIMessage=new LINEMessage(to,textMessage);
		//System.out.println(m.messages.size());
		return sendService.send(APIMessage);
		//return m;
		
		
		
		
		
		
	}

}
