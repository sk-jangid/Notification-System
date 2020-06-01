package com.Amazon.models.Message;

import com.Amazon.models.Message.Sender.Sender;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
@Value
@JsonTypeName("text")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class textMessage extends Message{

	 @NonNull
		public String text;
	    Sender sender;
	    public textMessage(final String text) {
	    	super("text");
	        this.text=text;
	        this.sender=new Sender();
	        
	    }
		
	
	    
	
}
