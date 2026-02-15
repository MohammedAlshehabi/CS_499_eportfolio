import java.util.List;
import java.util.Optional;

public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public void addContact(String firstName, String lastName, String phone, String address) {
        Contact contact = new Contact(firstName, lastName, phone, address);
        repository.create(contact);
    }

    public Optional<Contact> getContact(String contactId) {
        return repository.findById(contactId);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public void deleteContact(String contactId) {

        repository.deleteById(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Optional<Contact> optional = repository.findById(contactId);
        if (optional.isEmpty()) {
            return;
        }

        Contact contact = optional.get();
        contact.setFirstName(firstName);
        repository.update(contact);
    }

    public void updateLastName(String contactId, String lastName) {
        Optional<Contact> optional = repository.findById(contactId);
        if (optional.isEmpty()) {
            return;
        }

        Contact contact = optional.get();
        contact.setLastName(lastName);
        repository.update(contact);
    }

    public void updatePhone(String contactId, String phone) {
        Optional<Contact> optional = repository.findById(contactId);
        if (optional.isEmpty()) {
            return;
        }

        Contact contact = optional.get();
        contact.setPhone(phone);
        repository.update(contact);
    }

    public void updateAddress(String contactId, String address) {
        Optional<Contact> optional = repository.findById(contactId);
        if (optional.isEmpty()) {
            return;
        }

        Contact contact = optional.get();
        contact.setAddress(address);
        repository.update(contact);
    }
}
