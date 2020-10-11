public class Triangle extends Shape2D {
    private double length;
    private double height;
    public Triangle(double length, double height) {
        super();
        this.length = length;
        this.height = height;
    }

    public double getArea(){
        double area = (length * height)/2;
        return area;
    }
    public String getName(){
        return "triangle";
    }
}
