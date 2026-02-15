/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-320
 * Date:  January 26, 2025
 * Description: This was the contact service. It managed a list of contacts and handled adding, deleting, and updating contact details.
 *************************/



import java.util.ArrayList;

public class ContactService {
    // List to hold all contacts
    public ArrayList<Contact> contactList = new ArrayList<>();

    // Displayed all contacts in the list, which was useful for checking the data.
    public void displayContactList() {
        for (Contact contact : contactList) {
            System.out.println("\t Contact ID: " + contact.getContactID());
            System.out.println("\t First Name: " + contact.getFirstName());
            System.out.println("\t Last Name: " + contact.getLastName());
            System.out.println("\t Phone Number: " + contact.getNumber());
            System.out.println("\t Address: " + contact.getAddress() + "\n");
        }
    }

    // Added a new contact to the list.
    public void addContact(String firstName, String lastName, String number, String address) {
        Contact contact = new Contact(firstName, lastName, number, address);
        contactList.add(contact);
    }

    // Retrieved a contact from the list using its unique ID.
    public Contact getContact(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return new Contact(null, null, null, null); // Returned a default contact if not found
    }

    // Removed a contact from the list based on its unique ID.
    public void deleteContact(String contactID) {
        contactList.removeIf(contact -> contact.getContactID().equals(contactID));
    }

    // Updated the first name of a contact using its unique ID.
    public void updateFirstName(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setFirstName(updatedString);
                return;
            }
        }
    }

    // Updated the last name of a contact using its unique ID.
    public void updateLastName(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setLastName(updatedString);
                return;
            }
        }
    }

    // Changed the phone number of a contact using its unique ID.
    public void updateNumber(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setNumber(updatedString);
                return;
            }
        }
    }

    // Updated the address of a contact using its unique ID.
    public void updateAddress(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setAddress(updatedString);
                return;
            }
        }
    }
}
