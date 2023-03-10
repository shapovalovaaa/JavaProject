package com.epam.lab.entity;

import com.epam.lab.validators.ParamValidator;
import com.epam.lab.validators.ValidationParamError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CylinderTest {
    private ParamValidator paramValidator = new ParamValidator();
    @Test
    void CylindersEquals() {
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder();

        boolean result = cylinder1.equals(cylinder2);
        Assertions.assertTrue(result);
    }
    @Test
    public void testValidParam() {
        Cylinder cylinder = new Cylinder(5.25, 7.3);
        ValidationParamError responseHeight = paramValidator.validateParam(cylinder.getHeight());
        ValidationParamError responseRadius = paramValidator.validateParam(cylinder.getRadius());
        Assertions.assertEquals(responseHeight.getErrorMessages().size(), 0);
        Assertions.assertEquals(responseRadius.getErrorMessages().size(), 0);
    }
}
