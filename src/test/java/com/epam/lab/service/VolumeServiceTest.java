package com.epam.lab.service;

import com.epam.lab.entity.Cylinder;
import com.epam.lab.entity.PostMappingObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class VolumeServiceTest {
    private VolumeService volumeService = new VolumeService();
    @Test
    public void testVolume () {
        Cylinder cylinder = new Cylinder(5.25, 7.3);
        double expectedResult = 240.804;
        Assertions.assertEquals(expectedResult, volumeService.count(cylinder));
    }
    @Test
    public void postMappingResults() {
        List<Double> testList = Arrays.asList(13.3, 5.5, 99.9, 7.7, 1.1);
        Double expectedMin = 1.1;
        Double expectedMax = 99.9;
        Double expectedMedian = 25.5;
        Double expectedSum = 127.5;
        Double maxValue = volumeService.countMaxOfResult(testList);
        Double minValue = volumeService.countMinOfResult(testList);
        Double medianValue = volumeService.countMedianOfResult(testList);
        Double sum = volumeService.countSumOfResult(testList);
        Assertions.assertEquals(expectedMin, minValue);
        Assertions.assertEquals(expectedMax, maxValue);
        Assertions.assertEquals(expectedMedian, medianValue);
        Assertions.assertEquals(expectedSum, sum);
    }
}
