package com.Amazon.models;

import java.util.Collections;
import java.util.List;

import com.Amazon.models.Message.Message;

import lombok.AllArgsConstructor;
import lombok.Value;


// Generate a LINE Message to contact LINE API
@Value
@AllArgsConstructor
public class LINEMessage {
    
    public String to;
    public List<Message> messages;
    public boolean notificationDisabled;
    public LINEMessage(String to, Message message) {
        this.to=to;
        this.messages=Collections.singletonList(message);
        this.notificationDisabled= false;
    }

    public LINEMessage(String to, List<Message> messages) {
    	 this.to=to;
         this.messages=messages;
         this.notificationDisabled= false;
    }

    public LINEMessage(String to, Message message, boolean notificationDisabled) {
    	 this.to=to;
         this.messages=Collections.singletonList(message);
         this.notificationDisabled= notificationDisabled;
    }
}