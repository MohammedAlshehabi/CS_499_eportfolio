/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 25, 2026
 *************************/


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * ContactService class
 * This class manages a list of Contact objects.
 * It handles adding, updating, deleting, and displaying contacts.
 */
public class ContactService {

    // Private list to store contacts (encapsulation)
    private final List<Contact> contactList = new ArrayList<>();

    /*
     * Adds a new contact to the list
     */
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        contactList.add(new Contact(firstName, lastName, phoneNumber, address));
    }

    /*
     * Finds a contact by ID
     * Returns Optional to clearly handle "not found" cases
     */
    public Optional<Contact> getContact(String contactID) {
        return contactList.stream()
                .filter(c -> c.getContactID().equals(contactID))
                .findFirst();
    }

    /*
     * Deletes a contact by ID
     * Returns true if the contact was removed
     */
    public boolean deleteContact(String contactID) {
        return contactList.removeIf(c -> c.getContactID().equals(contactID));
    }

    /*
     * Helper method to find a contact or throw an error if not found
     */
    private Contact findContactOrFail(String contactID) {
        return getContact(contactID)
                .orElseThrow(() -> new IllegalArgumentException("Contact not found: " + contactID));
    }

    // Update methods for individual fields

    public void updateFirstName(String contactID, String newValue) {
        findContactOrFail(contactID).setFirstName(newValue);
    }

    public void updateLastName(String contactID, String newValue) {
        findContactOrFail(contactID).setLastName(newValue);
    }

    public void updatePhoneNumber(String contactID, String newValue) {
        findContactOrFail(contactID).setPhoneNumber(newValue);
    }

    public void updateAddress(String contactID, String newValue) {
        findContactOrFail(contactID).setAddress(newValue);
    }

    /*
     * Displays all contacts to the console
     */
    public void displayContactList() {
        for (Contact contact : contactList) {
            System.out.println("Contact ID: " + contact.getContactID());
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Address: " + contact.getAddress());
            System.out.println();
        }
    }

    /*
     * Returns a read-only copy of the contact list
     * Used only for testing purposes
     */
    List<Contact> getAllContacts() {
        return List.copyOf(contactList);
    }
}
