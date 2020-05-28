package com.Amazon.services.sendMessage.exception;

import java.util.List;

import com.Amazon.models.error.ErrorDetail;
import com.Amazon.models.error.ErrorResponse;


public class GeneralLineMessagingException extends LineMessagingException {
    private static final long serialVersionUID = SERIAL_VERSION_UID;

    public GeneralLineMessagingException(
            final List<ErrorDetail> list, final ErrorResponse errorResponse, final Throwable cause) {
        super(list, errorResponse, cause);
    }
    public GeneralLineMessagingException(
            final String message, final ErrorResponse errorResponse, final Throwable cause) {
        super(message, errorResponse, cause);
    }
}
