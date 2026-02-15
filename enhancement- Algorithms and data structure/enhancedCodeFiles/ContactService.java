/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 31, 2026
 *************************/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ContactService {

    // enhanced code to O(1) lookup + insertion order preserved
    private final Map<String, Contact> contacts = new LinkedHashMap<>();

    public void addContact(String firstName, String lastName, String phone, String address) {
        Contact contact = new Contact(firstName, lastName, phone, address);
        contacts.put(contact.getContactID(), contact);
    }

    public Optional<Contact> getContact(String contactId) {
        return Optional.ofNullable(contacts.get(contactId));
    }

    public Map<String, Contact> getAllContacts() {
        return contacts;
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    private Contact findContactOrFail(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contact;
    }

    public void updateFirstName(String contactId, String firstName) {
        findContactOrFail(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        findContactOrFail(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        findContactOrFail(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        findContactOrFail(contactId).setAddress(address);
    }
}
