package com.Amazon.models.Message.Sender;

import java.net.URI;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

// Sender class to alter the details of the Sender
@Value
@Builder
@JsonDeserialize(builder = Sender.SenderBuilder.class)
public class Sender {
	String name;
	URI iconUrl;
	@JsonPOJOBuilder(withPrefix = "")
    public static class SenderBuilder {
    }
	public Sender() {
		super();
		this.name="Rishu";
		this.iconUrl=URI.create("https://www.facebook.com/photo?fbid=1427547344060488&set=a.334280340053866");
	}
	public Sender(String name, URI iconUrl) {
		super();
		this.name = name;
		this.iconUrl = iconUrl;
	}
	
    
}
