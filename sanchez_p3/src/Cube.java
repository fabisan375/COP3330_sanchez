public class Cube extends Shape3D{
    private double sides;

    public Cube(double sides) {
        super();
        this.sides = sides;
    }

    public double getArea(){
        double area = (sides * sides)*6;
        return area;
    }
    public double getVolume(){
        double volume = (sides*sides*sides);
        return volume;
    }
    public String getName(){
        return "cube";
    }
}
