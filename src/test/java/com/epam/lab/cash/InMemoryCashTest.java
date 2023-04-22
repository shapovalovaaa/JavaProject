package com.epam.lab.cash;

import com.epam.lab.entity.Cylinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCashTest {
    private InMemoryCash inMemoryCash = new InMemoryCash();
    @Test
    void CashTest() {
        Cylinder cylinder1 = new Cylinder(5.25, 7.3, 240.804);
        Cylinder cylinder2 = new Cylinder(7.77, 8.77, 428.155);
        List<Cylinder> testList = new ArrayList<Cylinder>();
        testList.add(cylinder1);
        testList.add(cylinder2);
        inMemoryCash.saveCylinder(cylinder1);
        inMemoryCash.saveCylinder(cylinder2);

        Assertions.assertEquals(cylinder1, inMemoryCash.getCylinder(240.804));
        Assertions.assertEquals(cylinder2, inMemoryCash.getCylinder(428.155));
        Assertions.assertEquals(2, inMemoryCash.getCylinderCount());
        Assertions.assertFalse(inMemoryCash.getAllSavedCylinders().isEmpty());
        Assertions.assertEquals(testList.size(), inMemoryCash.getAllSavedCylinders().size());

    }

}