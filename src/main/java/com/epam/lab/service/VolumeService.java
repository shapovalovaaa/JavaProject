package com.epam.lab.service;

import com.epam.lab.entity.Cylinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeService {
    private static final Logger logger = LogManager.getLogger(Cylinder.class);

    public VolumeService() {};
    public Double count (Cylinder cylinder) {
        Double volume = 2 * Math.PI * cylinder.getHeight() * cylinder.getRadius();
        Double scale = Math.pow(10, 3);
        Double result = Math.ceil(volume * scale) / scale;
        logger.info("Count result");
        return result;
    }
    public Double countSumOfResult(List<Double> resultList) {
        Double sum = 0.0;
        if (!resultList.isEmpty()) {
            sum = resultList.stream().mapToDouble(Double::doubleValue).sum();
        }
        Double scale = Math.pow(10, 3);
        Double result = Math.ceil(sum * scale) / scale;
        logger.info("Count sum of results");
        return result;
    }
    public Double countMedianOfResult(List<Double> resultList) {
        Double median = 0.0;
        if (!resultList.isEmpty()) {
            median = resultList.stream().mapToDouble(Double::doubleValue).sum() / resultList.size();
        }
        Double scale = Math.pow(10, 3);
        Double result = Math.ceil(median * scale) / scale;
        logger.info("Count median value");
        return result;
    }
}