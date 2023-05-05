package com.epam.lab.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class RequestResponseTest {
    private RequestResponse response = mock(RequestResponse.class);
    @Test
    public void ResponseTest() {
        RequestResponse requestResponse = new RequestResponse();
        RequestResponse requestResponse1 = new RequestResponse("size", 3);

        requestResponse.setResponseMessage("size");
        requestResponse.setCounter(2);

        doNothing().when(response).setCounter(2);
        response.setCounter(2);
        verify(response, times(1)).setCounter(2);

        Assertions.assertEquals("size", requestResponse1.getResponseMessage());
        Assertions.assertEquals(3, requestResponse1.getCounter());
        Assertions.assertEquals("size", requestResponse.getResponseMessage());
        Assertions.assertEquals(2, requestResponse.getCounter());
    }
}
