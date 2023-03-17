package com.epam.lab.entity;

import org.springframework.stereotype.Component;

@Component
public class Cylinder {
    private double height;
    private double radius;
    private double volume;
    public Cylinder() {
        this.height = 0;
        this.radius = 0;
        this.volume = 0;
    }

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
        this.volume = 0;
    }
    public Cylinder(double height, double radius, double volume) {
        this.height = height;
        this.radius = radius;
        this.volume = volume;
    }

    public Cylinder(Cylinder cylinder) {
        this.height = cylinder.getHeight();
        this.radius = cylinder.getRadius();
        this.volume = cylinder.getVolume();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cylinder cylinder = (Cylinder) o;
        return ((this.height == cylinder.height && this.radius == cylinder.radius));
    }
}