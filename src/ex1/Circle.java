package ex1;

import static java.lang.System.exit;

public class Circle extends Shape{
    private final String ERROR ="terminated because radius of the circle must to be positive." ;
    private final Point center;
    private final int radius;



    public Circle( String color, Point center, int radius){
        super(color);
        this.center = center;
        this.radius = radius;
        checkValid();

    }

    private void checkValid() {
        if (radius <=0){
            System.out.println(ERROR);
            exit(1);
        }
    }

    @Override
    public void draw() {
        //drawing circle
    }
}
