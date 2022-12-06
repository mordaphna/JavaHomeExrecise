package ex1;

public class Rectangle implements Shape{

    //made them final because we are bot changing them.
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final String color;


    public Rectangle(Point p1,Point p2,Point p3, String color){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color= color;
    }
    @Override
    public void draw(){
        System.out.print("drawing rectangle in the positions: ");
        p1.printPoint();
        p2.printPoint();
        p3.printPoint();

        System.out.println();
        System.out.println("coloring the rectangle in color " + color+".");
        System.out.println();

    }
}
