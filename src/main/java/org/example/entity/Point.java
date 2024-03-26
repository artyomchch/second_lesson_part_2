package org.example.entity;


public class Point extends Shape {

    public Point(Coords coords) {
        this.coords = coords;
    }

    private Coords coords;


    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }




    public int getX() {
        return getCoords().getX();
    }

    private void setX(int x) {
        getCoords().setX(x);
    }

    public int getY() {
        return getCoords().getY();
    }

    private void setY(int y) {
        getCoords().setY(y);
    }


    @Override
    public void draw() {
        System.out.printf("Point is (%d, %d) and color - %s%n", getX(), getY(), getColor());
    }
}
