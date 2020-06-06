package com.Amazon.services.clients;

import java.util.HashMap;
import java.util.Map;

public class clientConfiguration {
	static LINEMessageClient lineClient=new LINEMessageClient();
	//static AlexaMessageClient alexaClient= new AlexaMessageClient();
    static Map<String, client> clientMap = new HashMap<>();
    static {
        clientMap.put("LINE",lineClient);
        //operationMap.put("Alexa", alexaClient);
  
    }

	public static client retrieveClient(String client) {
        return clientMap.get(client);
    }
}
