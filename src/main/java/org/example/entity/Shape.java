package org.example.entity;

import java.util.List;

public abstract class Shape {

    private String color;

    public Shape() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    List<Shape> objects;

    public abstract void draw();
}
