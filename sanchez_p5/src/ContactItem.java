import java.io.InvalidObjectException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    static Scanner input = new Scanner(System.in);
    public ContactItem() {
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.emailAddress = "";
    }
    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress ) throws ParseException, InvalidObjectException {
        if (firstName.length() == 0 && lastName.length() == 0 && phoneNumber.length() == 0 && emailAddress.length() == 0){
            throw new InvalidObjectException("WARNING: A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]. Please try again.");
        }
        else{
            if (isFirstNameValid(firstName)) {
                this.firstName = firstName;
            }
            else {
                throw new InvalidFirstNameException("WARNING: invalid first name; contact not created");
            }

            if (isLastNameValid(lastName)) {
                this.lastName = lastName;
            }
            else{
                throw new InvalidLastNameException("WARNING: invalid last name; contact not created");
            }

            if (isPhoneNumberValid(phoneNumber)){
                this.phoneNumber = phoneNumber;
            }
            else{
                throw new InvalidPhoneNumberException("WARNING: invalid phone-number, number must be in format (xxx-xxx-xxxx); contact not created");
            }
            if (isEmailAddressValid(emailAddress)){
                this.emailAddress = emailAddress;
            }
            else{
                throw new InvalidEmailAddressException("WARNING: invalid email address, email must be in format (x@y.z); contact not created");
            }
        }


    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.length() > 0){
            Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
            Matcher matcher = pattern.matcher(phoneNumber);

            return (matcher.matches());
        }
        else return (phoneNumber.length() >= 0);
    }

    private boolean isLastNameValid(String lastName) throws ParseException {
        return (lastName.length() >= 0);
    }

    private boolean isFirstNameValid(String firstName) {
        return firstName.length() >= 0;
    }
    private boolean isEmailAddressValid(String emailAddress) {
        if (emailAddress.length() > 0){
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            return (emailAddress.matches(regex));
        }
        else return (emailAddress.length() >= 0);
    }

    class InvalidFirstNameException extends IllegalArgumentException {
        public InvalidFirstNameException(String msg) {
            super(msg);
        }
    }
    class InvalidLastNameException extends IllegalArgumentException {
        public InvalidLastNameException(String msg) {
            super(msg);
        }
    }
    class InvalidPhoneNumberException extends IllegalArgumentException {
        public InvalidPhoneNumberException(String msg) {
            super(msg);
        }
    }
    class InvalidEmailAddressException extends IllegalArgumentException {
        public InvalidEmailAddressException(String msg) {
            super(msg);
        }
    }

    public String returnFirstName(){
        return firstName;
    }
    public String returnPhoneNumber(){
        return phoneNumber;
    }

    public String returnLastName(){
        return lastName;
    }
    public String returnEmailAddress(){
        return emailAddress;
    }

    public String edit_FirstName(String newFirstName){
        this.firstName = newFirstName;
        return firstName;
    }

    public String edit_PhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
        return phoneNumber;
    }

    public String edit_LastName(String newLastName){
        this.lastName = newLastName;
        return lastName;
    }
    public String edit_EmailAddress(String newEmailAddress){
        this.emailAddress = newEmailAddress;
        return emailAddress;
    }

    public String edit_ContactItems(String firstName, String lastName, String phoneNumber, String emailAddress) throws InvalidObjectException {
        if (firstName.length() == 0 && lastName.length() == 0 && phoneNumber.length() == 0 && emailAddress.length() == 0){
            throw new InvalidObjectException("WARNING: A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]. Please try again.");
        }
        else{
            edit_FirstName(firstName);
            edit_LastName(lastName);
            edit_EmailAddress(emailAddress);
            edit_PhoneNumber(phoneNumber);
        }
        return null;
    }

}
