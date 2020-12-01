import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainApp {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ParseException {
        int startMenuOptions = 0;
        while (startMenuOptions != 3){
            System.out.println("\nSelect Your Application");
            System.out.println("-----------------------\n");
            System.out.println("1) task list");
            System.out.println("2) contact list");
            System.out.println("3) quit");
            try{
                startMenuOptions = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex){
                System.out.println("WARNING: Please enter a number 1-3");
            }
            if (!isStartMenuOptionsValid(startMenuOptions)){
                throw new IndexOutOfBoundsException("WARNING: option selected is not a valid main menu option. Please try again and enter a number 1-3.");
            }
            switch (startMenuOptions){
                case 1:
                    new TaskApp();
                    break;
                case 2:
                    new ContactApp();
                    break;
                case 3:
                    break;
            }

        }
    }

    private static boolean isStartMenuOptionsValid(int startMenuOptions) {
        return (startMenuOptions >= 1 && startMenuOptions <=3);
    }
}
