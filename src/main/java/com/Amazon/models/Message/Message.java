package com.Amazon.models.Message;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = textMessage.class, name = "text"), 
		  //@Type(value = Truck.class, name = "truck") 
		})
public abstract class Message {

	protected String type;
    
	public Message(String type) {
        this.type=type;
    }

	public Message() {
		super();
	}
	
}
