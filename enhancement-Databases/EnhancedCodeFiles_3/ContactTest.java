import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("John", "Smith", "1234567890", "123 Street");
        assertNotNull(contact.getContactID());
    }

    @Test
    void testInvalidPhoneThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("John", "Smith", "123", "123 Street"));
    }

    @Test
    void testNullFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Smith", "1234567890", "123 Street"));
    }
}
