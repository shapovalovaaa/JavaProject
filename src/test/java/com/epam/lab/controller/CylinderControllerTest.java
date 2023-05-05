package com.epam.lab.controller;

import com.epam.lab.cash.InMemoryCash;
import com.epam.lab.entity.Cylinder;
import com.epam.lab.entity.PostMappingObject;
import com.epam.lab.service.VolumeService;
import com.epam.lab.validators.ParamValidator;
import com.epam.lab.validators.ValidationParamError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;


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
        when(paramValidator.validateParam(0.0)).thenReturn(new ValidationParamError("Bad Request", HttpStatus.BAD_REQUEST));
        when(paramValidator.validateParam(cylinder.getHeight())).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(cylinder.getRadius())).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(1000000000000.0)).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(17.0*(10^95))).thenReturn(new ValidationParamError());

        ResponseEntity<Object> case1 = cylinderController.cylinderVolume(0.0, Double.MAX_VALUE + 1);
        ResponseEntity<Object> case2 = cylinderController.cylinderVolume(0.0, cylinder.getRadius());
        ResponseEntity<Object> case3 = cylinderController.cylinderVolume(cylinder.getHeight(), Double.MAX_VALUE + 1);
        ResponseEntity<Object> case4 = cylinderController.cylinderVolume(1000000000000.0, 17.0*(10^95));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case1.getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case2.getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case3.getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case4.getStatusCode());
    }
    @Test
    public void validateParamTrue() {
        Cylinder c = new Cylinder(5.25, 7.3);
        when(paramValidator.validateParam(c.getHeight())).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(c.getRadius())).thenReturn(new ValidationParamError());
        when(volumeService.count(c)).thenReturn(240.804);

        ValidationParamError response = new ValidationParamError();
        response.setCylinder(cylinder);
        when(paramValidator.validateParam(240.804)).thenReturn(response);
        Assertions.assertEquals(cylinder, response.getCylinder());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
        ResponseEntity<Object> obj = cylinderController.cylinderVolume(c.getHeight(), c.getRadius());
        Assertions.assertEquals(HttpStatus.OK, obj.getStatusCode());
    }
    @Test
    public void cashTest() {
        inMemoryCash.saveCylinder(cylinder);
        Assertions.assertEquals(ResponseEntity.ok(inMemoryCash.getAllSavedCylinders()), cylinderController.getAllCylinders());
        Assertions.assertEquals(inMemoryCash.getCylinderCount(), cylinderController.getCylindersCount().getCounter());
    }
    @Test
    public void bulkTestTrue() {
        when(paramValidator.validateParam(1.1)).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(2.2)).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(7.7)).thenReturn(new ValidationParamError());
        when(paramValidator.validateParam(0.0)).thenReturn(new ValidationParamError("Bad Request", HttpStatus.BAD_REQUEST));

        Cylinder c1 = new Cylinder(1.1, 2.2);
        Cylinder c2 = new Cylinder(2.2, 0.0);
        Cylinder c3 = new Cylinder(0.0, 7.7);
        Cylinder c4 = new Cylinder(7.7, 1.1);

        when(volumeService.count(c1)).thenReturn(15.206);
        when(volumeService.count(c3)).thenReturn(53.219);

        List<Cylinder> cylinderList = new LinkedList<>();
        cylinderList.add(c1);
        cylinderList.add(c2);
        cylinderList.add(c3);
        cylinderList.add(c4);

        List<ValidationParamError> expectedResultList = new LinkedList<>();
        expectedResultList.add(new ValidationParamError("", HttpStatus.OK, c1));
        expectedResultList.add(new ValidationParamError("Invalid argument", HttpStatus.BAD_REQUEST));
        expectedResultList.add(new ValidationParamError("Invalid argument", HttpStatus.BAD_REQUEST));
        expectedResultList.add(new ValidationParamError("", HttpStatus.OK, c4));

        List<Double> expectedDoubleList = new LinkedList<>();
        expectedDoubleList.add(15.206);
        expectedDoubleList.add(53.219);
        Double expectedSumResult = 68.425;
        Double expectedMaxResult = 53.219;
        Double expectedMinResult = 15.206;
        Double expectedMedianResult = 34.213;
        PostMappingObject expectedInfo = new PostMappingObject(expectedResultList,
                expectedSumResult, expectedMinResult, expectedMaxResult, expectedMedianResult);

        ResponseEntity<Object> expectedObj = new ResponseEntity<>(expectedInfo, HttpStatus.CREATED);
        ResponseEntity<Object> obj = cylinderController.cylinderBulkVolume(cylinderList);
        Assertions.assertEquals(expectedObj.getStatusCode(), obj.getStatusCode());
    }
}

