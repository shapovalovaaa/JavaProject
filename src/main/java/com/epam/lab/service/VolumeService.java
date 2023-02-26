package com.epam.lab.service;

import com.epam.lab.entity.Cylinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeService {
    private static final Logger logger = LogManager.getLogger(Cylinder.class);
    private Cylinder cylinder;

    public VolumeService() {};
    @Autowired
    public VolumeService(Cylinder cylinder) {
        this.cylinder = cylinder;
    }
    public void setVolumeService(Cylinder cylinder) {
        this.cylinder = cylinder;
    }
    public double count () {
        double volume = 2 * Math.PI * cylinder.getHeight() * cylinder.getRadius();
        double scale = Math.pow(10, 3);
        double result = Math.ceil(volume * scale) / scale;
        logger.info("count result");
        return result;
    }
}
