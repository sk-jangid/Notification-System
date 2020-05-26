package com.Amazon.services.sendMessage;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.Amazon.services.sendMessage.MessageQuotaResponse.MessageQuotaResponseBuilder;

import lombok.Builder;
import lombok.Value;


/* Another response Object just for testing the API
 * Not Needed for our Service 
 */


@Value
@Builder
@JsonDeserialize(builder = MessageQuotaResponseBuilder.class)
public class MessageQuotaResponse {
    QuotaType type;
    long value;

    public enum QuotaType {
        none,
        limited
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class MessageQuotaResponseBuilder {
    }
}
