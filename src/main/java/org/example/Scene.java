package org.example;

import org.example.entity.Shape;

import java.util.Collection;
import java.util.List;

public class Scene {

    List<Shape> objects;

    public void draw() {
        for (Shape s : objects) {
            s.draw();
        }
    }
}
