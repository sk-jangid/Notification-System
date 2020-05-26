package com.Amazon.models.Message;

// class to generate a text Message
import com.Amazon.models.Message.Sender.Sender;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonTypeName("text")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(builder = textMessage.textMessageBuilder.class)
public class textMessage implements Message {
    @NonNull
	public String text;
    Sender sender;
    public textMessage(final String text) {
        this.text=text;
        this.sender=null;
    }
    @JsonPOJOBuilder(withPrefix = "")
    public static class textMessageBuilder {
    	
    	
    }

   
    
}
