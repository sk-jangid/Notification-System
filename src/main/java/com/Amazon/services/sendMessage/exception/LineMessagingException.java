
package com.Amazon.services.sendMessage.exception;



import com.Amazon.models.error.ErrorResponse;

import lombok.Getter;

@Getter
public abstract class LineMessagingException extends Exception {
    static final long SERIAL_VERSION_UID = 0x001_003; 
    private static final long serialVersionUID = SERIAL_VERSION_UID;

   
    LineMessagingException(final String message, final ErrorResponse errorResponse,final Throwable cause) {
       super(message + (errorResponse != null ? " : " + errorResponse : ""), cause);
    }
}
