
package com.Amazon.services.sendMessage.exception;

import com.Amazon.models.error.ErrorResponse;

public class BadRequestException extends LineMessagingException {
    private static final long serialVersionUID = SERIAL_VERSION_UID;

    public BadRequestException(
            final String message,
            final ErrorResponse errorResponse) {
        super(message, errorResponse, null);
    }
}
