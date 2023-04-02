package com.epam.lab.counter;

public class RequestResponse {
    private int counter;
    private String responseMessage;
    public RequestResponse() {
        this.counter = 0;
        this.responseMessage = "";
    }
    public RequestResponse (String responseMessage, int counter) {
        this.counter = counter;
        this.responseMessage = responseMessage;
    }
    public int getCounter() {
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
