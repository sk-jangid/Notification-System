package com.Amazon.services.sendMessage;

import static java.util.Collections.emptyList;

import java.util.List;

import com.Amazon.services.sendMessage.responseBody.responseBodyBuilder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;


/*
 * Response Body for responses of API
 */
@Value
@Builder
@JsonDeserialize(builder = responseBodyBuilder.class)
public
class responseBody {
    @JsonPOJOBuilder(withPrefix = "")
    public static class responseBodyBuilder {
        // filled by lombok.
    }

    public String message;
    @Default
    public List<String> details = emptyList();

    ApiResponse withRequestId(final String requestId) {
        return new ApiResponse(requestId, message, details);
    }

}
