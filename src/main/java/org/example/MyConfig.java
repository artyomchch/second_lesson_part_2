package org.example;

import org.example.entity.Circle;
import org.example.entity.Coords;
import org.example.entity.Point;
import org.example.entity.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:figure.properties")
public class MyConfig {

    @Autowired
    private Environment env;

    @Value("${point.x}")
    private int x;
    @Value("${point.y}")
    private int y;

    @Value("${point.color}")
    private String color;

    @Value("${circle.radius}")
    private int radius;

//    @Value("#{default}")
//    private Coords coords;

    @Bean("default")
    @Scope("prototype")
    public Coords coords() {
        return new Coords();
    }

    @Bean()
    @Scope("prototype")
    public Coords coords1(@Value("#{default.x}") int x, @Value("#{default.y}") int y) {
        return new Coords(x, y);
    }



    @Bean
    public Point pointBean() {
        Point p = new Point(coords());
        p.setColor(color);
        return p;

    }


    @Bean("defaultCircle")
    @Scope("prototype")
    public Circle circleBean() {
        Circle c = new Circle(coords1(
                env.getProperty("circle.x", Integer.class),
                env.getProperty("circle.y", Integer.class)),
                env.getProperty("circle.radius", Integer.class));
        c.setColor(env.getProperty("circle.radius", String.class));

        return c;
    }

    @Bean
    @Scope("prototype")
    public Circle circle(@Value("#{default.x}") int r){
        Circle c = new Circle();
        c.setRadius(r);
        return c;
    }

    @Bean
    @Lazy
    public Scene scene(){
        Scene s = new Scene();
        s.objects = new ArrayList<Shape>();
        for (int i =0; i< 2; i++){
            s.objects.add(pointBean());
            s.objects.add(circleBean());
        }
        return s;
        //s.objects = new ArrayList<Shape>()
    }


}
