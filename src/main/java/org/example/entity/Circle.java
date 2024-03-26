package org.example.entity;

public class Circle extends Shape {

    public Circle() {
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(Coords coords, int radius) {
        this.coords = coords;
        this.radius = radius;
    }

    private Coords coords;
    private int radius;


    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Circle radius is %s and coords (%s, %s) and color - %s%n", getRadius(),
                getCoords().getX(), getCoords().getY(), getColor());
    }
}
