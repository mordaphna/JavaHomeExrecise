package ex1;

public class Circle implements Shape{
    private final int radios;
    private final Point center;
    private final String color;

    public Circle(Point center, int radios, String color){
        this.center = center;
        this.radios = radios;
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.print("drawing circle in the center position: ");
        center.printPoint();
        System.out.println( " with " + "the radios: "+ radios +".");
        System.out.println("coloring the circle in color " + color+".");
        System.out.println();


    }
}
