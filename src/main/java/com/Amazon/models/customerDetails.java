package com.Amazon.models;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component

// currently implemented according to my need in the actual service they are retrieved by another service
public class customerDetails {
	String customerId;
	String name;
	String LINEuserId;
	String AlexaID;

}
