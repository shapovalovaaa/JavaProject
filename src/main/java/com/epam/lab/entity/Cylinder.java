package com.epam.lab.entity;

import org.springframework.stereotype.Component;

@Component
public class Cylinder {
    private Double height;
    private Double radius;
    private Double volume;

    public Cylinder() {
        this.height = 0.0;
        this.radius = 0.0;
        this.volume = 0.0;
    }

    public Cylinder(Double height, Double radius) {
        this.height = height;
        this.radius = radius;
        this.volume = 0.0;
    }
    public Cylinder(Double height, Double radius, Double volume) {
        this.height = height;
        this.radius = radius;
        this.volume = volume;
    }

    public Cylinder(Cylinder cylinder) {
        this.height = cylinder.getHeight();
        this.radius = cylinder.getRadius();
        this.volume = cylinder.getVolume();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        /*if (o == null) return false;
        if (o == null || getClass() != o.getClass()) return false;*/

        Cylinder cylinder = (Cylinder) o;
        return ((this.height == cylinder.height && this.radius == cylinder.radius));
    }
}