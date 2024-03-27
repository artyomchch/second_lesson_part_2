package org.example;

import org.example.entity.Circle;
import org.example.entity.Coords;
import org.example.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration(enforceUniqueMethods = false)
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
    public Coords coords(@Value("#{T(java.lang.Math).random()*30}") int x,
                          @Value("#{T(java.lang.Math).random()*30}") int y) {
        return new Coords(x, y);
    }


    @Bean
    @Scope("prototype")
    public Point pointBean() {
        Point p = new Point(coords());
        p.setColor(color);
        return p;

    }


    @Bean("defaultCircle")
    @Scope("prototype")
    public Circle circleBean() {
        Circle c = new Circle(coords(
                env.getProperty("circle.x", Integer.class, 2),
                env.getProperty("circle.y", Integer.class, 2)),
                env.getProperty("circle.radius", Integer.class, 23));
        c.setColor(env.getProperty("circle.color", String.class));

        return c;
    }

    @Bean
    @Scope("prototype")
    public Circle circle(@Value("#{default.x}") int r) {
        Circle c = new Circle();
        c.setRadius(r);
        return c;
    }

    @Bean
    @Lazy
    public Scene scene() {
        Scene s = new Scene();
        s.objects = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            s.objects.add(pointBean());
            s.objects.add(circleBean());
        }
        return s;
        //s.objects = new ArrayList<Shape>()
    }


}
