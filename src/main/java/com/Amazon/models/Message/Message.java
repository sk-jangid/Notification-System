package com.Amazon.models.Message;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Message {

	protected String type;
    
	public Message(String type) {
        this.type=type;
    }
	
}
