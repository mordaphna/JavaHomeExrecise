package ex1;

public class Circle extends Shape{
    private final Point center;
    private final int radios;


    public Circle( String color, Point center, int radios ){
        super(color);
        this.center = center;
        this.radios = radios;
    }
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
