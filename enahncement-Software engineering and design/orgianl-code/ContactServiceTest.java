/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-320
 * Date:  January 26, 2025
 * Description: These were the unit tests for the contact service (ContactServiceTest).
 *************************/


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

    /*
     * These tests verified the functionality of the ContactService class.
     * A new service was created, changes were made, and results were checked.
     */
    @Test
    @DisplayName("Test to Update First Name.")
    @Order(1)
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");

        // Get the contact ID dynamically
        String contactID = service.contactList.get(0).getContactID();

        service.updateFirstName("Alex", contactID);
        assertEquals("Alex", service.getContact(contactID).getFirstName(), "First name was not updated.");
    }

    @Test
    @DisplayName("Test to Update Last Name.")
    @Order(2)
    void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");

        // Get the contact ID dynamically
        String contactID = service.contactList.get(0).getContactID();

        service.updateLastName("Taylor", contactID);
        assertEquals("Taylor", service.getContact(contactID).getLastName(), "Last name was not updated.");
    }

    @Test
    @DisplayName("Test to update phone number.")
    @Order(3)
    void testUpdatePhoneNumber() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");

        // Get the contact ID dynamically
        String contactID = service.contactList.get(0).getContactID();

        service.updateNumber("7135557890", contactID);
        assertEquals("7135557890", service.getContact(contactID).getNumber(), "Phone number was not updated.");
    }

    @Test
    @DisplayName("Test to update address.")
    @Order(4)
    void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");

        // Get the contact ID dynamically
        String contactID = service.contactList.get(0).getContactID();

        service.updateAddress("742 Evergreen Terrace", contactID);
        assertEquals("742 Evergreen Terrace", service.getContact(contactID).getAddress(), "Address was not updated.");
    }

    @Test
    @DisplayName("Test to ensure that service correctly deleted contacts.")
    @Order(5)
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");

        // Get the contact ID dynamically
        String contactID = service.contactList.get(0).getContactID();

        service.deleteContact(contactID);
        assertEquals(0, service.contactList.size(), "The contact was not deleted.");
    }

    @Test
    @DisplayName("Test to ensure that service added a contact.")
    @Order(6)
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");

        // Get the contact ID dynamically
        String contactID = service.contactList.get(0).getContactID();

        assertNotNull(service.getContact(contactID), "Contact was not added correctly.");
    }

    @Test
    @DisplayName("Test to display contact list.")
    @Order(7)
    void testDisplayContactList() {
        ContactService service = new ContactService();
        service.addContact("John", "Doe", "1234567890", "123 Street");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        service.displayContactList();

        String printedOutput = outputStream.toString();
        assertTrue(printedOutput.contains("John"), "First name not found in output.");
        assertTrue(printedOutput.contains("Doe"), "Last name not found in output.");
        assertTrue(printedOutput.contains("1234567890"), "Phone number not found in output.");
        assertTrue(printedOutput.contains("123 Street"), "Address not found in output.");

        System.setOut(System.out);
    }


}
