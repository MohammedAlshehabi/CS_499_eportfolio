/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 25, 2026
 *************************/


import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    /*
     * Tests updating a contact's first name
     */
    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts().get(0).getContactID();
        service.updateFirstName(id, "Alex");

        assertEquals("Alex", service.getContact(id).get().getFirstName());
    }

    /*
     * Tests deleting a contact
     */
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts().get(0).getContactID();
        assertTrue(service.deleteContact(id));
    }

    /*
     * Tests that updating a non-existing contact throws an exception
     */
    @Test
    void testUpdateNonexistentContactThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("999", "Fail"));
    }

    /*
     * Tests displayContactList output
     */
    @Test
    void testDisplayContactList() {
        ContactService service = new ContactService();
        service.addContact("John", "Doe", "1234567890", "123 Street");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        service.displayContactList();

        System.setOut(originalOut);

        String output = out.toString();
        assertTrue(output.contains("John"));
        assertTrue(output.contains("Doe"));
    }
}
