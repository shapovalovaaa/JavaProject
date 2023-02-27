package com.epam.lab.validators;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ValidationParamError {
    private List<String> errorMessages = new ArrayList<String>();
    private HttpStatus status;

    public void addErrorMessage(String errorMessage) {
        this.errorMessages.add(errorMessage);
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setErrorMessages(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
