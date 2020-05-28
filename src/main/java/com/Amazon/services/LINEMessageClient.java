package com.Amazon.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Amazon.models.LINEMessage;
import com.Amazon.models.Message.Message;
import com.Amazon.models.Message.textMessage;
import com.Amazon.services.sendMessage.responseBody;
import com.Amazon.services.sendMessage.sendService;

import retrofit2.Response;



// Service to initiate the process of Message Sending by generating the Message from text
@Service
public class LINEMessageClient {
	
	static Response<responseBody> sendMessage(List<String> message,String to) throws IOException  {
		
		// Message type is text
		List<Message> textMessage=new ArrayList<>();
		/*
		 * Max Limit is to send 5 Messages
		 */
		for(int i=0;i<message.size();i++) {
			textMessage.add(new textMessage(message.get(i)));
		}

		LINEMessage APIMessage=new LINEMessage(to,textMessage);
		return sendService.send(APIMessage);
	
	
		
	}

}
