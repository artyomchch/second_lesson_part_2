package org.example;

import org.example.entity.Circle;
import org.example.entity.Coords;
import org.example.entity.Point;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Coords coords = context.getBean("coords1", Coords.class);
        System.out.println(coords.getX());
       Point point = context.getBean("pointBean", Point.class);
       point.draw();
        Circle circle = context.getBean("defaultCircle", Circle.class);
        circle.draw();

        Scene scene= context.getBean("scene", Scene.class);
        scene.draw();
//        point.draw();
       // System.out.println(coords.getX());
        context.close();


    }
}
