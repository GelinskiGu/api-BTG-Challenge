package com.gelinski.apiBtgChallenge.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAllowedRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotAllowedRequestException(String ex) {
        super(ex);
    }
}
