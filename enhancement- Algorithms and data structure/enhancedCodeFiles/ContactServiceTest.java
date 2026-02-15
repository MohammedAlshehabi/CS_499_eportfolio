/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 31, 2026
 *************************/



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");
        assertEquals(1, service.getAllContacts().size());
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts()
                .values()
                .iterator()
                .next()
                .getContactID();

        service.deleteContact(id);
        assertEquals(0, service.getAllContacts().size());
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts()
                .values()
                .iterator()
                .next()
                .getContactID();

        service.updateFirstName(id, "Alex");
        assertEquals("Alex", service.getContact(id).get().getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts()
                .values()
                .iterator()
                .next()
                .getContactID();

        service.updateLastName(id, "Brown");
        assertEquals("Brown", service.getContact(id).get().getLastName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts()
                .values()
                .iterator()
                .next()
                .getContactID();

        service.updatePhone(id, "0987654321");
        assertEquals("0987654321", service.getContact(id).get().getPhone());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact("John", "Smith", "1234567890", "123 Street");

        String id = service.getAllContacts()
                .values()
                .iterator()
                .next()
                .getContactID();

        service.updateAddress(id, "456 Avenue");
        assertEquals("456 Avenue", service.getContact(id).get().getAddress());
    }
}
