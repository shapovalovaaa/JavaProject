package com.epam.lab.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RequestResponseTest {
    @Test
    public void ResponseTest() {
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setResponseMessage("size");
        requestResponse.setCounter(2);

        Assertions.assertEquals("size", requestResponse.getResponseMessage());
        Assertions.assertEquals(2, requestResponse.getCounter());
    }
}
