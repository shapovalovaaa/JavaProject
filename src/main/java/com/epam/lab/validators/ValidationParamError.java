package com.epam.lab.validators;

import com.epam.lab.entity.Cylinder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ValidationParamError {
    private Cylinder cylinder;
    private List<String> errorMessages;
    private HttpStatus status;

    public ValidationParamError() {
        this.errorMessages = new ArrayList<>();
        this.status = HttpStatus.OK;
    }
    public ValidationParamError(String message, HttpStatus status) {
        this.errorMessages = new ArrayList<>();
        errorMessages.add(message);
        this.status = status;
    }
    public ValidationParamError(String message, HttpStatus status, Cylinder cylinder) {
        this.errorMessages = new ArrayList<>();
        errorMessages.add(message);
        this.status = status;
        this.cylinder = cylinder;
    }
    public void addErrorMessage(String errorMessage) {
        this.errorMessages.add(errorMessage);
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
    public void setCylinder(Cylinder cylinder) {
        this.cylinder = cylinder;
    }
    public Cylinder getCylinder() {
        return this.cylinder;
    }
}