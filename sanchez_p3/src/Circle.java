public class Circle extends Shape2D{
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public double getArea(){
        double area = (radius * radius)*3.1416;
        return area;
    }
    public String getName(){
        return "circle";
    }
}
