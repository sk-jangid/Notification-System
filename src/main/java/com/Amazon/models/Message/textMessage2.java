package com.Amazon.models.Message;

import com.Amazon.models.Message.Sender.Sender;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class textMessage2 extends Message2{

	 @NonNull
		public String text;
	    Sender sender;
	    public textMessage2(final String text) {
	    	super("text");
	        this.text=text;
	        this.sender=null;
	        
	    }
		public textMessage2() {
			super("text");
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Sender getSender() {
			return sender;
		}
		public void setSender(Sender sender) {
			this.sender = sender;
		}
	    
	
}
