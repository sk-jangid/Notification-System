
package com.Amazon.services.sendMessage.exception;



import java.util.List;

import com.Amazon.models.error.ErrorDetail;
import com.Amazon.models.error.ErrorResponse;

import lombok.Getter;

@Getter
public abstract class LineMessagingException extends Exception {
    static final long SERIAL_VERSION_UID = 0x001_003; 
    private static final long serialVersionUID = SERIAL_VERSION_UID;

   
    LineMessagingException(final List<ErrorDetail> list, final ErrorResponse errorResponse,final Throwable cause) {
       super(list + (errorResponse != null ? " : " + errorResponse : ""), cause);
    }
    LineMessagingException(final String message, final ErrorResponse errorResponse,final Throwable cause) {
    	
        super(message + (errorResponse != null ? " : " + errorResponse : ""), cause);
     }
}
