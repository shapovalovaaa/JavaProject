package com.epam.lab.controller;

import com.epam.lab.cash.InMemoryCash;
import com.epam.lab.entity.Cylinder;
import com.epam.lab.service.VolumeService;
import com.epam.lab.validators.ParamValidator;
import com.epam.lab.validators.ValidationParamError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CylinderControllerTest {
    private VolumeService volumeService = mock(VolumeService.class);
    private ParamValidator paramValidator = mock(ParamValidator.class);
    private InMemoryCash inMemoryCash = new InMemoryCash();
    @InjectMocks
    private CylinderController cylinderController = new CylinderController(volumeService, paramValidator, inMemoryCash);
    private static final Cylinder cylinder = mock(Cylinder.class);
    @BeforeAll
    public static void setup () {
        when(cylinder.getHeight()).thenReturn(5.25);
        when(cylinder.getRadius()).thenReturn(7.3);
    }
    @Test
    public void validateParamFalse () {
        when(paramValidator.validateParam(Double.MAX_VALUE + 1)).thenReturn(new ValidationParamError("Bad Request", HttpStatus.BAD_REQUEST));
        when(paramValidator.validateParam(0)).thenReturn(new ValidationParamError("Bad Request", HttpStatus.BAD_REQUEST));
        when(paramValidator.validateParam(cylinder.getHeight())).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(cylinder.getRadius())).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(1000000000000.0)).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(17*10^95)).thenReturn(new ValidationParamError());
        ResponseEntity<Object> case1 = cylinderController.cylinderVolume(0, Double.MAX_VALUE + 1);
        ResponseEntity<Object> case2 = cylinderController.cylinderVolume(0, cylinder.getRadius());
        ResponseEntity<Object> case3 = cylinderController.cylinderVolume(cylinder.getHeight(), Double.MAX_VALUE + 1);
        ResponseEntity<Object> case4 = cylinderController.cylinderVolume(1000000000000.0, 17*10^95);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case1.getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case2.getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case3.getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case4.getStatusCode());
    }
    @Test
    void validateParamTrue() {
        Cylinder c = new Cylinder(5.25, 7.3);
        when(paramValidator.validateParam(c.getHeight())).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(c.getRadius())).thenReturn(new ValidationParamError());

        when(volumeService.count(c)).thenReturn(240.804);
        when(paramValidator.validateParam(240.804)).thenReturn(new ValidationParamError());
        ResponseEntity<Object> obj = cylinderController.cylinderVolume(c.getHeight(), c.getRadius());
        Assertions.assertEquals(HttpStatus.OK, obj.getStatusCode());

    }
    @Test
    void cashTest() {
        inMemoryCash.saveCylinder(cylinder);
        Assertions.assertEquals(ResponseEntity.ok(inMemoryCash.getCylinderCount()), cylinderController.getCylindersCount());
        Assertions.assertEquals(ResponseEntity.ok(inMemoryCash.getAllSavedCylinders()), cylinderController.getAllCylinders());
    }
}

