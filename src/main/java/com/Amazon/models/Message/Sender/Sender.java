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
		this.name="Amazon Notifications";
		this.iconUrl=URI.create("https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-9/53877594_2327542794131255_3206055299618177024_n.jpg?_nc_cat=104&_nc_sid=09cbfe&_nc_ohc=jxsUDOwfmvYAX_nxQl3&_nc_ht=scontent.fdel1-2.fna&oh=2563ab31b037b515b78f5c39b1b61eab&oe=5EF90762");
	}
	public Sender(String name, URI iconUrl) {
		super();
		this.name = name;
		this.iconUrl = iconUrl;
	}
	
    
}
