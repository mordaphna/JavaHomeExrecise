package ex1;

public class Square extends Shape {
    private final int length;

    public Square(String color, int length){
        super(color);
        this.length = length;

    }

    @Override
    public void draw(){
        System.out.println("drawing square");

    }
}


