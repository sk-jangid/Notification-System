
package com.Amazon.services.sendMessage.exception;

import java.util.List;

import com.Amazon.models.error.ErrorDetail;
import com.Amazon.models.error.ErrorResponse;

public class BadRequestException extends LineMessagingException {
    private static final long serialVersionUID = SERIAL_VERSION_UID;

    public BadRequestException(
            final List<ErrorDetail> list,
            final ErrorResponse errorResponse) {
        super(list, errorResponse, null);
    }
}
