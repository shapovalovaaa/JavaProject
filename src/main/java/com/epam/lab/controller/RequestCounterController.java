package com.epam.lab.controller;

import com.epam.lab.counter.RequestCounter;
import com.epam.lab.counter.RequestResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestCounterController {
    Logger logger = LogManager.getLogger(RequestCounterController.class);
    @GetMapping(value="/api/lab/counter")
    public RequestResponse getRequestCounter() {
        logger.info("Visited RequestCounterController");
        return new RequestResponse("Request count", RequestCounter.getCounter());
    }
}
