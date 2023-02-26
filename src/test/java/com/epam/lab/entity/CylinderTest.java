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
    @Test
    void CylinderToString() {
        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(6.66);
        cylinder.setRadius(5.55);
        String result = "\n" + cylinder.getClass() + "{ " +
                "height = " + 6.66 +
                ", radius = " + 5.55 + " }";
        Assertions.assertEquals(cylinder.toString(), result);
    }
}
