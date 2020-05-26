package com.Amazon.services.sendMessage.exception;

import com.Amazon.models.error.ErrorResponse;


public class GeneralLineMessagingException extends LineMessagingException {
    private static final long serialVersionUID = SERIAL_VERSION_UID;

    public GeneralLineMessagingException(
            final String message, final ErrorResponse errorResponse, final Throwable cause) {
        super(message, errorResponse, cause);
    }
}
