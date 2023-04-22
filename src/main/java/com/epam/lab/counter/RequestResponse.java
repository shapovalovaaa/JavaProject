package com.epam.lab.counter;

public class RequestResponse {
    private Integer counter;
    private String responseMessage;
    public RequestResponse() {
        this.counter = 0;
        this.responseMessage = "";
    }
    public RequestResponse (String responseMessage, Integer counter) {
        this.counter = counter;
        this.responseMessage = responseMessage;
    }
    public Integer getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}