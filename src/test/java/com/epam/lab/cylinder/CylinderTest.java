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
}
