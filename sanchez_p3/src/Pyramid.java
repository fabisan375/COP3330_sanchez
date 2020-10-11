import java.lang.Math;
public class Pyramid extends Shape3D{
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        double area = (length*width)+(length*Math.sqrt(((width/2)*(width/2))+(height*height)))+(width*Math.sqrt(((length/2)*(length/2))+(height*height)));
        return area;
    }
    public double getVolume(){
        double volume = (length*width*height)/3;
        return volume;
    }
    public String getName(){
        return "pyramid";
    }
}
