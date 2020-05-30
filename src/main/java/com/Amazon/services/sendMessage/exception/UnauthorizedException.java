	package com.Amazon.services.sendMessage.exception;

import com.Amazon.models.error.ErrorResponse;

//package com.linecorp.bot.client.exception;

//import com.linecorp.bot.model.error.ErrorResponse;

public class UnauthorizedException extends LineMessagingException {
    private static final long serialVersionUID = SERIAL_VERSION_UID;

    public UnauthorizedException(
            final String message,
            final ErrorResponse errorResponse) {
        super(message, errorResponse, null);
    }
}
