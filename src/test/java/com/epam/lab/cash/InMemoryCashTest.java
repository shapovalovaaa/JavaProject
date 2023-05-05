package com.epam.lab.cash;

import com.epam.lab.counter.RequestResponse;
import com.epam.lab.entity.Cylinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InMemoryCashTest {
    private static final Cylinder cylinder = mock(Cylinder.class);
    private InMemoryCash inMemoryCash = mock(InMemoryCash.class);
    @Test
    void CashTest() {
        InMemoryCash newInMemoryCash = new InMemoryCash();
        Cylinder cylinder1 = new Cylinder(5.25, 7.3, 240.804);
        Cylinder cylinder2 = new Cylinder(7.77, 8.77, 428.155);
        List<Cylinder> testList = new ArrayList<Cylinder>();
        testList.add(cylinder1);
        testList.add(cylinder2);
        newInMemoryCash.saveCylinder(cylinder1);
        newInMemoryCash.saveCylinder(cylinder2);

        Assertions.assertEquals(cylinder1, newInMemoryCash.getCylinder(240.804));
        Assertions.assertEquals(cylinder2, newInMemoryCash.getCylinder(428.155));
        Assertions.assertEquals(2, newInMemoryCash.getCylinderCount());
        Assertions.assertFalse(newInMemoryCash.getAllSavedCylinders().isEmpty());
        Assertions.assertEquals(testList.size(), newInMemoryCash.getAllSavedCylinders().size());
    }
    @Test
    public void cashSaveTest() {
        doNothing().when(inMemoryCash).saveCylinder(cylinder);
        inMemoryCash.saveCylinder(cylinder);
        inMemoryCash.saveCylinder(cylinder);
        inMemoryCash.saveCylinder(cylinder);
        verify(inMemoryCash, times(3)).saveCylinder(cylinder);
    }
}