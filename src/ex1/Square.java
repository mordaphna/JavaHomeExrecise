package ex1;

public class Square implements Shape {
    //made them final because we are bot changing them.
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;
    private final String color;


    public Square(Point p1,Point p2,Point p3,Point p4, String color){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.color = color;

    }

    @Override
    public void draw(){
        System.out.print("drawing square in the positions: ");
        p1.printPoint();
        p2.printPoint();
        p3.printPoint();
        p4.printPoint();

        System.out.println();
        System.out.println("coloring the square in color " + color+".");
        System.out.println();
    }
}


