public class Sphere extends Shape3D{
    private double radius;

    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    public double getArea(){
        double area = 4*3.14159*(radius*radius);
        return area;
    }
    public double getVolume(){
        double volume = (1.333333333333)*3.1415926536*(radius*radius*radius);
        return volume;
    }
    public String getName(){
        return "sphere";
    }
}
