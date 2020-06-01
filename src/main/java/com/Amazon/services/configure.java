package com.Amazon.services;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Amazon.services.sendMessage.LINEClient;
import com.Amazon.services.sendMessage.sendService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


//@AutoConfigureAfter(LineBotWebMvcConfigurer.class)
//@EnableConfigurationProperties(LineBotProperties.class)

@Configuration
public class configure {
	
	//JSONObject commMethods=FileAbstractHandler.getJSONObjectFromFile("src\\main\\Abstracts\\communicationMethods.json");
	@ConditionalOnMissingBean
	@Bean
    public sendService lineClient() {
		LINEClient client =new LINEClient();
        
		return  client.channelAccessToken("MEGhysNQpGvlM3aMs+g9FaQJcOA0oDD2zKxbUU6O933/QTqiB0zBITtUyjjVHSDY42CD76e/0BjibGyZR5iYZynmbcX042lQqy7eP2YApioEFfTExQypkuGECIZ4ayba54Y9PaTrCOIvRbvixAdeoQdB04t89/1O/w1cDnyilFU=").build();
    }
	//@EnableConfigurationProperties(LINEMessageClient.class)
	
	@ConditionalOnMissingBean
	@Bean
    public LINEMessageClient lineMessageClient() {
        return  new LINEMessageClient(lineClient());
		//return null;
    }
	/*@ConditionalOnMissingBean
	@Bean
	public communicationMethods commmethod() throws JsonParseException, JsonMappingException, IOException, ParseException {
			return new communicationMethods(FileAbstractHandler.getJSONObjectFromFile("src\\main\\Abstracts\\communicationMethods.json"));	
	}*/
	@ConditionalOnMissingBean
	@Bean
	public servicehandler handler() throws JsonParseException, JsonMappingException, IOException, ParseException {
		return new servicehandler(lineMessageClient());
	}
	
	
	
	
	
}
