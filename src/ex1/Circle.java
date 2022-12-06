package ex1;

import static java.lang.System.exit;

public class Circle extends Shape{
    private final String ERROR ="terminated because radios of the circle must to be positive." ;
    private final Point center;
    private final int radios;



    public Circle( String color, Point center, int radios ){
        super(color);
        this.center = center;
        this.radios = radios;
        checkValid();

    }

    private void checkValid() {
        if (radios<=0){
            System.out.println(ERROR);
            exit(1);
        }
    }

    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
