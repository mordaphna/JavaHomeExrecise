package ex1;


public abstract class Shape{
    private final String color;

    public Shape(String color){
        this.color = color;
    }

    //so that the classes that extends shape will have access to color.
    public String getColor(){
        return this.color;
    }
    public abstract void draw();

}