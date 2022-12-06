package ex1;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args)
    {
        List<Shape> shapes = new ArrayList<>();

        Circle circle1 = new Circle("pink",new Point(1, 1), 5);
        Circle circle2 = new Circle("blue",new Point(3, 3), 4);

        Rectangle rectangle = new Rectangle("red", 4,3);
        Shape square = new Square("green",3);


        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(rectangle);
        shapes.add(square);


        for (Shape shape : shapes) {
            shape.draw();
        }

    }
}
