package com.epam.lab.service;

import com.epam.lab.entity.Cylinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class VolumeServiceTest {
    private VolumeService volumeService = new VolumeService();
    @Test
    public void testVolume () {
        Cylinder cylinder = new Cylinder(5.25, 7.3);
        double expectedResult = 240.804;
        Assertions.assertEquals(expectedResult, volumeService.count(cylinder));
    }
}
