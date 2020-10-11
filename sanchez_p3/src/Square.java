public class Square extends Shape2D {
    private double sides;

    public Square(double sides) {
        super();
        this.sides = sides;
    }

    public double getArea(){
        double area = sides * sides;
        return area;
    }
    public String getName(){
        return "square";
    }
}
