package ex1;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static List<Shape> shapes;

    public static void initialize(){
        shapes = new ArrayList<>();
    }

    public static void drawShapes(List<Shape> shapes){
        for (Shape shape : shapes) {
            shape.draw();
        }
    }


    //FOR DEBUG
    public static void main(String[] args){
        initialize();
        shapes.add(new Circle("pink",new Point(1, 1), 5));
        shapes.add(new Rectangle("red", 4,3));
        shapes.add(new Square("green",2));
        drawShapes(shapes);
    }

}
