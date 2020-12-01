import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    private ArrayList<ContactItem> contactArray;

    public ContactList() {
        this.contactArray = new ArrayList<ContactItem>();
    }

    public void add(String firstName, String lastName, String phoneNumber, String emailAddress) throws ParseException, InvalidObjectException {
        this.contactArray.add(new ContactItem(firstName, lastName, phoneNumber, emailAddress));
    }
    public void delete(int index){
        this.contactArray.remove(index);
    }

    public int size(){
        return this.contactArray.size();
    }

    public String returnFirstName(int index) {
        return contactArray.get(index).returnFirstName();
    }

    public String returnPhoneNumber(int index) {
        return contactArray.get(index).returnPhoneNumber();
    }

    public String returnEmailAddress(int index) {
        return contactArray.get(index).returnEmailAddress();
    }

    public String returnLastName(int index) {
        return contactArray.get(index).returnLastName();
    }

    public String editContactList(int index, String newFirstName, String newLastName, String newPhoneNumber, String newEmailAddress) throws InvalidObjectException {
        return contactArray.get(index).edit_ContactItems(newFirstName, newLastName, newEmailAddress, newPhoneNumber);
    }

    public void save(String filename) throws IOException {
        PrintWriter pw;
        try {
            pw = new PrintWriter(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        pw.print(size() + "\n");
        for (int i = 0; i < size(); i++) {
            pw.print(contactArray.get(i).returnFirstName() + "\n");
            pw.print(contactArray.get(i).returnLastName() + "\n");
            pw.print(contactArray.get(i).returnPhoneNumber() + "\n");
            pw.print(contactArray.get(i).returnEmailAddress() + "\n");
        }
        pw.close();
    }
    public void load(String filename) throws ParseException, FileNotFoundException, InvalidObjectException {
        Scanner input;
        if (!isFilenameValid(filename)) {
            input = new Scanner(new File(filename));
        }
        else {
            throw new FileNotFoundException("Warning: file named enter could not be found or does not exist, please double check it and try again");
        }

        String firstName;
        String lastName;
        String phoneNumber;
        String emailAddress;
        int size = Integer.parseInt(input.nextLine());
        for (int i = 0; i < size; i++) {
            firstName = input.nextLine();
            lastName = input.nextLine();
            phoneNumber = input.nextLine();
            emailAddress = input.nextLine();
            this.add(firstName, lastName, phoneNumber, emailAddress);
        }
        input.close();
    }

    private static boolean isFilenameValid(String filename) {
        File temp = new File(filename);
        if (temp.exists())
            return false;
        return true;
    }

}