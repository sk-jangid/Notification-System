package com.Amazon.models.Message;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = textMessage2.class, name = "text"), 
		  //@Type(value = Truck.class, name = "truck") 
		})
public abstract class Message2 {

	protected String type;
    
	public Message2(String type) {
        this.type=type;
    }

	public Message2() {
		super();
	}
	
}
