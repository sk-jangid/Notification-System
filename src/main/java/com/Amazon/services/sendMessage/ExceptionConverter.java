package com.Amazon.services.sendMessage;


//package com.linecorp.bot.client;

import static java.util.Collections.singletonMap;

import java.io.IOException;
import java.util.function.Function;

import com.Amazon.models.error.ErrorResponse;
import com.Amazon.services.sendMessage.exception.BadRequestException;

import com.Amazon.services.sendMessage.exception.GeneralLineMessagingException;
import com.Amazon.services.sendMessage.exception.LineMessagingException;
import com.Amazon.services.sendMessage.exception.UnauthorizedException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;


import okhttp3.ResponseBody;
import retrofit2.Response;

class ExceptionConverter implements Function<Response<?>, LineMessagingException> {
    public static final ObjectReader OBJECT_READER = new ObjectMapper().readerFor(ErrorResponse.class);

    @Override
    public LineMessagingException apply(Response<?> response) {
        final String requestId = response.headers().get("x-line-request-id");
        try {
            return applyInternal(requestId, response);
        } catch (Exception e) {
            final ErrorResponse errorResponse = new ErrorResponse(requestId, null, null);
            return new GeneralLineMessagingException(e.getMessage(), errorResponse, e);
        }
    }

    private static LineMessagingException applyInternal(final String requestId, final Response<?> response)
            throws IOException {
        final int code = response.code();
        final ResponseBody ApiResponse = response.errorBody();
        ///System.out.println(responseBody);
        final ErrorResponse errorResponse = OBJECT_READER
                .with(new InjectableValues.Std(singletonMap("requestId", requestId)))
                .readValue(ApiResponse.byteStream());

        switch (code) {
            case 400:
            	for(int i=0;i<errorResponse.getDetails().size();i++) {
            		 System.out.println((errorResponse.getDetails().get(i)).getMessage() + " :"+ (errorResponse.getDetails().get(i)).getProperty());
            	}
            	//System.out.println(errorResponse.getMessage());
                return new BadRequestException(
                        errorResponse.getMessage(), errorResponse);
            case 401:
            	for(int i=0;i<errorResponse.getDetails().size();i++) {
           		 System.out.println((errorResponse.getDetails().get(i)).getMessage() + " :"+ (errorResponse.getDetails().get(i)).getProperty());
           	}
            	//System.out.println(errorResponse.getMessage());

            	System.out.println("skkj");
            	return new UnauthorizedException(
                        errorResponse.getMessage(), errorResponse);
            	
        }

        return new GeneralLineMessagingException(errorResponse.getMessage(), errorResponse, null);
    }
}
