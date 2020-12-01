import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.io.InvalidObjectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(java.io.InvalidObjectException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new ContactItem("Peter", "Parker", "111-111-2222", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new ContactItem("", "Parker", "111-111-2222", "PeterParker@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new ContactItem("Peter", "", "111-111-2222", "PeterParker@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new ContactItem("Peter", "Parker", "", "PeterParker@gmail.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new ContactItem("Peter", "Parker", "111-111-2222", "PeterParker@gmail.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues() throws ParseException, InvalidObjectException {
        ContactItem contactItem = new ContactItem  ("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        Assertions.assertThrows(java.io.InvalidObjectException.class, () ->{
            contactItem.edit_ContactItems("", "", "", "");
        });
    }

    @Test
    public void editingSucceedsWithBlankEmail() throws ParseException, InvalidObjectException {
        ContactItem contactItem = new ContactItem  ("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactItem.edit_ContactItems("Donald", "Drumpf", "666-666-6666", "");
    }

    @Test
    public void editingSucceedsWithBlankFirstName() throws ParseException, InvalidObjectException {
        ContactItem contactItem = new ContactItem  ("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactItem.edit_ContactItems("", "Drumpf", "666-666-6666", "DonaldJDrumpf@gmail.com");
    }

    @Test
    public void editingSucceedsWithBlankLastName() throws ParseException, InvalidObjectException {
        ContactItem contactItem = new ContactItem  ("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactItem.edit_ContactItems("Donald", "", "666-666-6666", "DonaldJDrumpf@gmail.com");
    }

    @Test
    public void editingSucceedsWithBlankPhone() throws ParseException, InvalidObjectException {
        ContactItem contactItem = new ContactItem  ("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactItem.edit_ContactItems("Donald", "Drumpf", "", "DonaldJDrumpf@gmail.com");
    }

    @Test
    public void editingSucceedsWithNonBlankValues() throws ParseException, InvalidObjectException {
        ContactItem contactItem = new ContactItem  ("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactItem.edit_ContactItems("Donald", "Drumpf", "666-666-6666", "DonaldJDrumpf@gmail.com");
    }
}