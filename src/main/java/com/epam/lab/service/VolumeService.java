package com.epam.lab.service;

import com.epam.lab.counter.RequestCounterThread;
import com.epam.lab.counter.Synchronization;
import com.epam.lab.entity.Cylinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeService {
    private static final Logger logger = LogManager.getLogger(Cylinder.class);

    public VolumeService() {};
    public double count (Cylinder cylinder) {
        double volume = 2 * Math.PI * cylinder.getHeight() * cylinder.getRadius();
        double scale = Math.pow(10, 3);
        double result = Math.ceil(volume * scale) / scale;
        logger.info("Count result");
        return result;
    }
}