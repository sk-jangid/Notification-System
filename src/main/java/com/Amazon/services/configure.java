package com.Amazon.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Amazon.services.sendMessage.LINEClient;
import com.Amazon.services.sendMessage.sendService;



@Configuration
public class configure {
	@Bean
    public sendService lineClient() {        
		return 	new LINEClient().build();
    }
	@Bean
    public LINEMessageClient lineMessageClient() {
        return  new LINEMessageClient(lineClient());
		//return null;
    }
	
	
	
	
	
}
