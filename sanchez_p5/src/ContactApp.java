import java.io.IOException;
import java.io.InvalidObjectException;
import java.rmi.NoSuchObjectException;
import java.text.ParseException;
import java.util.Scanner;
public class ContactApp {
    static Scanner input = new Scanner(System.in);

    public ContactApp() throws ParseException, IOException {

        ContactList contactList;
        int mainMenuOptions = 0;

        while (mainMenuOptions != 3) {
            mainMenu();
            try {
                mainMenuOptions = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex){
                System.out.println("WARNING: Please enter a number 1-3");
            }
            if (!isMainMenuOptionsValid(mainMenuOptions)){
                throw new IndexOutOfBoundsException("WARNING: option selected is not a valid main menu option. Please try again and enter a number 1-3.");
            }
            switch (mainMenuOptions) {
                case 1 -> {
                    contactList = new ContactList();
                    System.out.println("\nNew contact list has been created\n");
                    operationMenu(contactList);
                }
                case 2 -> {
                    contactList = new ContactList();
                    System.out.print("Enter the filename to load: ");
                    contactList.load(input.nextLine());
                    System.out.println("task list has been loaded");
                    operationMenu(contactList);
                }
            }
        }
    }

    private static boolean isMainMenuOptionsValid(int mainMenuOptions) {
        return (mainMenuOptions >= 1 && mainMenuOptions <= 3);
    }


    private static void operationMenu (ContactList contactList) throws IOException, ParseException {
        String firstName;
        String lastName;
        String phoneNumber;
        String emailAddress;
        int listOperationsMenuOptions = 0;
        while (listOperationsMenuOptions != 6
        ) {
            displayOperationMenu();
            try{
                listOperationsMenuOptions = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException ex){
                System.out.println("WARNING: Please enter a number 1-6");
            }
            if (!isListOperationsMenuOptionsValid(listOperationsMenuOptions)){
                throw new IndexOutOfBoundsException("WARNING: option selected is not a valid list operation menu option. Please try again and enter a number 1-6.");
            }

            switch (listOperationsMenuOptions) {
                case 1:
                    int size = contactList.size();
                    System.out.println("\nCurrent contacts");
                    System.out.println("---------\n");
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            System.out.println(i + ") " + "Name: " + contactList.returnFirstName(i) + " " + contactList.returnLastName(i) + "\nPhone: " + contactList.returnPhoneNumber(i) + "\nEmail: " + contactList.returnEmailAddress(i));
                        }
                    } else System.out.println("");
                    break;
                case 2:
                    firstName = getFirstName();
                    lastName = getLastName();
                    phoneNumber = getPhoneNumber();
                    emailAddress = getEmailAddress();
                    if (firstName.length() == 0 && lastName.length() == 0 && phoneNumber.length() == 0 && emailAddress.length() == 0){
                        throw new InvalidObjectException("WARNING: A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]. Please try again.");
                    }
                    else{
                        contactList.add(firstName, lastName, phoneNumber, emailAddress);
                    }

                    break;
                case 3:
                    size = contactList.size();
                    if (size > 0){
                        System.out.println("\nCurrent contacts");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            System.out.println(i + ") " + "Name: " + contactList.returnFirstName(i) + " " + contactList.returnLastName(i) + "\nPhone: " + contactList.returnPhoneNumber(i) + "\n Email: " + contactList.returnEmailAddress(i));
                        }
                        System.out.print("\nWhich contact will you edit?: ");
                        int contactNumber = 0;
                        try{
                            contactNumber = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException ex){
                            System.out.printf("WARNING: Please enter a number 0-%d\n", size);
                        }

                        System.out.printf("\nEnter a new first name for contact %d: ", contactNumber);
                        String newFirstName = input.nextLine();

                        System.out.printf("\nEnter a new last name for contact %d: ", contactNumber);
                        String newLastName = input.nextLine();

                        System.out.printf("\nEnter a new phone number for contact %d (xxx-xxx-xxxx): ", contactNumber);
                        String newPhoneNumber = input.nextLine();

                        System.out.printf("\nEnter a new email address for contact %d (x@y.z): ", contactNumber);
                        String newEmailAddress = input.nextLine();

                        contactList.editContactList(contactNumber, newFirstName, newLastName, newPhoneNumber, newEmailAddress);
                    }
                    else throw new InvalidObjectException("WARNING: There are currently no contacts to edit. Please try again and create a contact first.");

                    break;
                case 4:
                    size = contactList.size();
                    if (size > 0){
                        System.out.println("\nCurrent contacts");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            System.out.println(i + ") " + "Name: " + contactList.returnFirstName(i) + " " + contactList.returnLastName(i) + "\nPhone: " + contactList.returnPhoneNumber(i) + "\n Email: " + contactList.returnEmailAddress(i));
                        }
                        System.out.print("\nWhich contact will you remove?: ");
                        int contactNumber = 0;
                        try{
                            contactNumber = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException ex){
                            System.out.printf("WARNING: Please enter a number 0-%d\n", size);
                        }
                        contactList.delete(contactNumber);
                    }
                    else throw new InvalidObjectException("WARNING: There are currently no contacts to remove. Please try again and create a contact first.");
                    break;
                case 5:
                    if (contactList.size() == 0){
                        throw new NoSuchObjectException("WARNING: A contact list shall contain 1 or more contact items. Please try again");
                    }
                    else{
                        System.out.print("Enter the filename to save as: ");
                        contactList.save(input.nextLine());
                        System.out.println("contact list has been saved");
                    }

                    break;
            }
        }
    }

    private static boolean isListOperationsMenuOptionsValid(int listOperationsMenuOptions) {
        return (listOperationsMenuOptions >= 1 && listOperationsMenuOptions <= 6);
    }

    private static void mainMenu () {
        System.out.println("\nMain Menu");
        System.out.println("---------\n");

        System.out.println("1) Create a new contact list");
        System.out.println("2) Load an existing contact list");
        System.out.println("3) Quit");
    }
    private static void displayOperationMenu () {
        System.out.println("\nList Operation Menu");
        System.out.println("---------\n");

        System.out.println("1) View the List");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Save the current list");
        System.out.println("6) Quit to the main menu");
    }
    private static String getLastName () {
        System.out.println("Enter last name: ");
        return input.nextLine();
    }

    private static String getPhoneNumber () {
        System.out.println("Enter phone number (xxx-xxx-xxxx): ");
        return input.nextLine();
    }

    private static String getFirstName () {
        System.out.println("Enter first name: ");
        return input.nextLine();
    }

    private static String getEmailAddress () {
        System.out.println("Enter email address (x@y.z): ");
        return input.nextLine();
    }
}