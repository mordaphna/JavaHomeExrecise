package ex1;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args)
    {
        List<Shape> shapes = new ArrayList<>();

        Circle circle1 = new Circle(new Point(1, 1), 5, "pink");
        Circle circle2 = new Circle(new Point(3, 3), 4, "blue");
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(3, 7), new Point(10,
                1), "green");
        Square square = new Square(new Point(1, 0), new Point(1, 3), new Point(4, 3),
                new Point(4, 0), "yellow");

        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(rectangle);
        shapes.add(square);

        for (Shape shape : shapes) {
            shape.draw();
        }

    }
}
