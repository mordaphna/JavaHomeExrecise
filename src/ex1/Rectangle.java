package ex1;

public class Rectangle extends Shape{
    private final int height;
    private final int width;


    public Rectangle(String color, int height, int width){
        super(color);
        this.height = height;
        this.width = width;

    }
    @Override
    public void draw(){
        System.out.println("drawing rectangle");

    }
}
