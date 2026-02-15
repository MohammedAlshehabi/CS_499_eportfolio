import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        ContactRepository repository = new JdbcContactRepository();
        JdbcContactRepository.deleteAll();
        service = new ContactService(repository);
    }

    @Test
    void testAddContact() {
        service.addContact("Mohammed", "Alshehabi", "1234567890", "123 Street");
        List<Contact> contacts = service.getAllContacts();
        assertEquals(1, contacts.size());
    }

    @Test
    void testDeleteContact() {
        service.addContact("John", "Smith", "1234567890", "123 Street");
        List<Contact> contacts = service.getAllContacts();
        String id = contacts.get(0).getContactID();

        service.deleteContact(id);

        contacts = service.getAllContacts();
        assertEquals(0, contacts.size());
    }

    @Test
    void testUpdateFirstName() {
        service.addContact("John", "Smith", "1234567890", "123 Street");
        List<Contact> contacts = service.getAllContacts();
        String id = contacts.get(0).getContactID();

        service.updateFirstName(id, "Alex");

        Contact updated = service.getContact(id).orElseThrow();
        assertEquals("Alex", updated.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact("John", "Smith", "1234567890", "123 Street");
        List<Contact> contacts = service.getAllContacts();
        String id = contacts.get(0).getContactID();

        service.updateLastName(id, "Brown");

        Contact updated = service.getContact(id).orElseThrow();
        assertEquals("Brown", updated.getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact("John", "Smith", "1234567890", "123 Street");
        List<Contact> contacts = service.getAllContacts();
        String id = contacts.get(0).getContactID();

        service.updatePhone(id, "0987654321");

        Contact updated = service.getContact(id).orElseThrow();
        assertEquals("0987654321", updated.getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact("John", "Smith", "1234567890", "123 Street");
        List<Contact> contacts = service.getAllContacts();
        String id = contacts.get(0).getContactID();

        service.updateAddress(id, "456 Avenue");

        Contact updated = service.getContact(id).orElseThrow();
        assertEquals("456 Avenue", updated.getAddress());
    }
}
