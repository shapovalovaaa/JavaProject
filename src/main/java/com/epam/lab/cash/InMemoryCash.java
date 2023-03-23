package com.epam.lab.cash;

import com.epam.lab.entity.Cylinder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryCash {
    private Map<Double, Cylinder> dataCash = new HashMap<Double, Cylinder>();
    public void saveCylinder(Cylinder cylinder) {
        dataCash.put(cylinder.getVolume(), cylinder);
    }
    public Cylinder getCylinder (Double volume) {
        return dataCash.get(volume);
    }
    public Integer getCylinderCount() {
        return dataCash.size();
    }
    public List<Cylinder> getAllSavedCylinders() {
        List<Cylinder> listCylinders = new ArrayList<Cylinder>();
        dataCash.forEach((k, v) -> listCylinders.add(v));
        return listCylinders;
    }
}
