package ex1;

import static java.lang.System.exit;

public class Rectangle extends Shape{

    private final int height;
    private final int width;
    private final String ERROR = "terminated because both height and width must to be positive.";
    public Rectangle(String color, int height, int width){
        super(color);
        this.height = height;
        this.width = width;
        checkValid();


    }


    public void checkValid(){
        if (width <=0 || height<=0){
            System.out.println(ERROR);
            exit(1);
        }
    }

    @Override
    //this draw function will be called on square as well (we draw a rectangle and a square the same)
    public void draw(){
        //drawing rectangle

    }
}
