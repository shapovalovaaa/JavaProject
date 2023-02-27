package com.epam.lab.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CylinderTest {
    @Test
    void CylindersEquals() {
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder();

        boolean result = cylinder1.equals(cylinder2);
        Assertions.assertTrue(result);
    }
}
