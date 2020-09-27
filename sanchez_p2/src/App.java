import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    private static double getUserHeight() {
        Scanner scanner = new Scanner(System.in);
        double height = 0;
        int noNegativeNumbs = 0;
        while(noNegativeNumbs == 0) {
            System.out.println("Enter your height in inches: ");
            String userHeight = scanner.nextLine();
            height = Integer.parseInt(userHeight);

            if (height <= 0 ) System.out.println("Height must be a positive nonzero integer please try again.");
            else if (height > 0) {
                noNegativeNumbs = 1;
            }
        }
        return height;
    }
    private static double getUserWeight() {
        Scanner scanner = new Scanner(System.in);
        double weight = 0;
        int noNegativeNums = 0;
        while(noNegativeNums == 0) {
            System.out.println("Enter your weight in pounds: ");
            String userWeight = scanner.nextLine();
            weight = Integer.parseInt(userWeight);

            if (weight <= 0 ) System.out.println("Weight must be a positive nonzero integer please try again.");
            else if (weight > 0) {
                noNegativeNums = 1;
            }
        }
        return weight;
    }
    private static void displayBmiInfo(BodyMassIndex bmi){
        System.out.printf("Your BMI score is %.1f and your BMI category falls under %s \n\n", bmi.bmiScore, bmi.bmiName);
    }
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> sumation){
        int sum = 0;
        double average = 0;
        for (BodyMassIndex value : sumation){
            sum += value.bmiScore;
            average = sum/(sumation.size());
        }
        System.out.println("The average BMI score is " + average);
    }
    private static boolean moreInput(){
        Scanner scanner = new Scanner(System.in);
        int enterCorrectChar = 0;
        while (enterCorrectChar == 0) {
            System.out.println("Would you like to calculate your body mass index? Please enter Y for yes or N for no.");
            char input = scanner.next().charAt(0);
            if (input == 'N') {
                enterCorrectChar = 2;
                return false;
            }
            if(input == 'Y') {
                enterCorrectChar = 1;
                return true;
            }
            else System.out.println("Sorry, response must be a Y for yes or N no\n");
        }
        return false;
    }
}
