package com.epam.lab.service;

import com.epam.lab.entity.Cylinder;
import com.epam.lab.exception.ValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VolumeServiceTest {
    /*@Test
    public void maxDoubleTest()
    {
        UserController userController = new UserController();
        userController.cylinderVolume(Double.MAX_VALUE+1, 33);
    }*/
    @Test
    public void Volume () {
        Cylinder cylinder = new Cylinder(5.25, 7.3);
        VolumeService volumeService = new VolumeService(cylinder);
        double expectedResult = 240.804;
        Assertions.assertEquals(expectedResult, volumeService.count());
    }
}
