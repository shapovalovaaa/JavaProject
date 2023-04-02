package com.epam.lab.cylinder;

import com.epam.lab.entity.Cylinder;
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
    void CylinderEqualsAllParams() {
        Cylinder cylinder1 = new Cylinder(4.5, 3.3, 2.2);
        Cylinder cylinder2 = new Cylinder(4.5, 3.3, 2.2);

        boolean result = cylinder1.equals(cylinder2);
        Assertions.assertTrue(result);
    }
    @Test
    void CylinderSetters() {
        Cylinder cylinder1 = new Cylinder(15.5, 7.77, 756.716);
        Cylinder cylinder2 = new Cylinder();
        cylinder2.setHeight(15.5);
        cylinder2.setRadius(7.77);
        cylinder2.setVolume(756.716);

        Assertions.assertEquals(cylinder1.getHeight(), cylinder2.getHeight());
        Assertions.assertEquals(cylinder1.getRadius(), cylinder2.getRadius());
        Assertions.assertEquals(cylinder1.getVolume(), cylinder2.getVolume());
    }

    @Test
    void CylinderCopy() {
        Cylinder cylinder1 = new Cylinder(15.5, 7.77, 756.716);
        Cylinder cylinder2 = new Cylinder(cylinder1);

        Assertions.assertEquals(cylinder1.getHeight(), cylinder2.getHeight());
        Assertions.assertEquals(cylinder1.getRadius(), cylinder2.getRadius());
        Assertions.assertEquals(cylinder1.getVolume(), cylinder2.getVolume());
    }
}
