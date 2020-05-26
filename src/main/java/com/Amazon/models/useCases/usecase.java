package com.Amazon.models.useCases;

import org.json.JSONObject;

public class usecase {
	
	String event;
	String customerId;
	JSONObject eventDetails;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public JSONObject getEventDetails() {
		return eventDetails;
	}
	public void setEventDetails(JSONObject eventDetails) {
		this.eventDetails = eventDetails;
	}
	public usecase(String event, String customerId, JSONObject eventDetails) {
		super();
		this.event = event;
		this.customerId = customerId;
		this.eventDetails = eventDetails;
	}
	
	
	public usecase() {
		
	}
	
	
	

}
