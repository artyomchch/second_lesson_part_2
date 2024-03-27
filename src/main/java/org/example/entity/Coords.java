package org.example.entity;

import org.springframework.beans.factory.annotation.Value;

public class Coords {

    private int x;
    private int y;
    public Coords() {}

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }



    public int getX() {
        return x;
    }
    @Value("#{T(java.lang.Math).random()*50}")
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    @Value("#{T(java.lang.Math).random()*50}")
    public void setY(int y) {
        this.y = y;
    }
}
