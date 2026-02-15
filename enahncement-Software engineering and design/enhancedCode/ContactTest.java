/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 25, 2026
 *************************/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    /*
     * Tests that a valid contact is created successfully
     */
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("John", "Smith", "1234567890", "123 Street");
        assertNotNull(contact.getContactID());
    }

    /*
     * Tests that an invalid phone number throws an exception
     */
    @Test
    void testInvalidPhoneThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("John", "Smith", "123", "123 Street"));
    }

    /*
     * Tests that a null first name throws an exception
     */
    @Test
    void testNullFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Smith", "1234567890", "123 Street"));
    }
}
