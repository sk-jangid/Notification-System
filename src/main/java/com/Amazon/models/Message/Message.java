package com.Amazon.models.Message;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(textMessage.class),
       // @JsonSubTypes.Type(orderStatusMessage.class),
      
})
public interface Message {

	//char[] text = null;
	
  
}