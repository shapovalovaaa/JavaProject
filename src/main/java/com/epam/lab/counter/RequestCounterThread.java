package com.epam.lab.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestCounterThread extends Thread {
    Logger logger = LogManager.getLogger(RequestCounterThread.class);

    public RequestCounterThread() {
        start();
    }
    @Override
    public void run() {
        try {
            logger.info(Thread.currentThread().getName() + " is waiting for resolution");
            Synchronization.semaphore.acquire();
            RequestCounter.increment();
            logger.info("Counter after increment " + RequestCounter.getCounter());
        } catch (InterruptedException e) {
            logger.error("Thread was interrupted");
        }
        Synchronization.semaphore.release();
    }
}
