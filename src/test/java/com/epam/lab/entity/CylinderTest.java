package com.epam.lab.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CylinderTest {
    Cylinder cylinder = mock(Cylinder.class);
    @Test
    void CylinderSetters() {
        Cylinder cylinder1 = new Cylinder(15.5, 7.77, 756.716);
        Cylinder cylinder2 = new Cylinder();
        cylinder2.setHeight(15.5);
        cylinder2.setRadius(7.77);
        cylinder2.setVolume(756.716);

        doNothing().when(cylinder).setHeight(15.5);
        doNothing().when(cylinder).setRadius(7.77);
        doNothing().when(cylinder).setVolume(756.716);
        cylinder.setHeight(15.5);
        cylinder.setRadius(7.77);
        cylinder.setVolume(756.716);
        verify(cylinder, times(1)).setHeight(15.5);
        verify(cylinder, times(1)).setRadius(7.77);
        verify(cylinder, times(1)).setVolume(756.716);

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
