package com.epam.lab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValueException extends ResponseStatusException {
    public ValueException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
