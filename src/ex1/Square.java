package ex1;

public class Square extends Rectangle {
    public Square(String color, int length){
        super(color,length,length);

    }

    @Override
    public void draw(){
        System.out.println("drawing square");

    }
}


