import java.util.Scanner;
public class BodyMassIndex {
    public String bmiName;
    public double bmiScore;

    public BodyMassIndex(double height, double weight) {
        bmiScore = calculateBmi(height, weight);
        bmiName = bmiCategory(bmiScore);
    }

    public double calculateBmi(double height, double weight) {
        double bmiValue = 703 * (weight / (height * height));
        if (bmiValue < 0) {
            return 0;
        }
        return bmiValue;
    }
    public String bmiCategory(double bmi){
        String bmiCat = "";
        if (bmi < 18.5)
            bmiCat = "Underweight";
        if (bmi >= 18.5 && bmi <= 24.9)
            bmiCat = "Normal weight";
        if (bmi >=25 && bmi <= 29.9)
            bmiCat = "Overweight";
        else if (bmi > 30)
            bmiCat = "Obese";
        return bmiCat;
    }
}


