import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        assertEquals(1, contactList.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        Assertions.assertThrows(java.io.InvalidObjectException.class, () ->{
            contactList.editContactList(0, "", "", "", "");
        });
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        Assertions.assertThrows(java.lang.IndexOutOfBoundsException.class, () ->{
            contactList.editContactList(2, "", "", "", "");
        });
    }

    @Test
    public void editingItemsSucceedsWithBlankFirstName() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.editContactList(0, "", "Obama", "666-666-6666", "Obunga@gmail.com");
    }

    @Test
    public void editingItemsSucceedsWithBlankLastName() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.editContactList(0, "Barack", "", "666-666-6666", "Obunga@gmail.com");
    }

    @Test
    public void editingItemsSucceedsWithBlankPhone() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.editContactList(0, "Barack", "Obama", "", "Obunga@gmail.com");
    }

    @Test
    public void editingItemsSucceedsWithBlankEmail() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.editContactList(0, "Barack", "Obama", "666-666-6666", "");
    }

    @Test
    public void editingItemsSucceedsWithNonBlankValues() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.editContactList(0, "Barack", "Obama", "666-666-6666", "Obunga@gmail.com");
    }

    @Test
    public void newListIsEmpty() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        assertEquals(0, contactList.size());
    }

    @Test
    public void removingItemsDecreasesSize() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.add("Mary", "Jane", "999-999-9990", "MaryJane@gmail.com");
        contactList.delete(0);
        assertEquals(1, contactList.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() throws ParseException, InvalidObjectException {
        ContactList contactList = new ContactList();
        contactList.add("Peter", "Parker", "999-999-9999", "PeterParker@gmail.com");
        contactList.add("Mary", "Jane", "999-999-9990", "MaryJane@gmail.com");
        Assertions.assertThrows(java.lang.IndexOutOfBoundsException.class, () ->{
            contactList.delete(3);
        });
    }

    @Test
    public void savedContactListCanBeLoaded() throws ParseException, IOException {
        ContactList contactList = new ContactList();
        contactList.add("Jason", "", "", "");
        contactList.add("Jason", "", "", "");
        contactList.save("test.txt");
        ContactList contactList2 = new ContactList();
        contactList2.load("test.txt");
        int success = 0;
        if(contactList.returnFirstName(0).equals(contactList2.returnFirstName(0))){
            success = 1;
        }
        assertEquals(1, success);
    }
}