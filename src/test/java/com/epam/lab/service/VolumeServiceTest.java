package com.epam.lab.service;

import com.epam.lab.entity.Cylinder;
import com.epam.lab.validators.ParamValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class VolumeServiceTest {
    @InjectMocks
    private VolumeService volumeService = new VolumeService();
    @Test
    public void Volume () {
        Cylinder cylinder = new Cylinder(5.25, 7.3);
        double expectedResult = 240.804;
        Assertions.assertEquals(expectedResult, volumeService.count(cylinder));
    }

}
