/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-320
 * Date:  January 26, 2025
 * Description: These were the unit tests for the contact class (ContactTest).
 *************************/


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class ContactTest {
    /*
     * These tests verified that the contact details followed the rules and constraints.
     */
    @Test
    @DisplayName("Contact ID could not have more than 10 characters.")
    void testContactIDWithMoreThanTenCharacters() {
        Contact contact = new Contact("John", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");
        if (contact.getContactID().length() > 10) {
            fail("Contact ID had more than 10 characters.");
        }
    }

    @Test
    @DisplayName("Contact First Name could not have more than 10 characters.")
    void testContactFirstNameWithMoreThanTenCharacters() {
        Contact contact = new Contact("AlexanderTheGreat", "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");
        if (contact.getFirstName().length() > 10) {
            fail("First Name had more than 10 characters.");
        }
    }

    @Test
    @DisplayName("Contact Last Name could not have more than 10 characters.")
    void testContactLastNameWithMoreThanTenCharacters() {
        Contact contact = new Contact("John", "JohnsonJohnson", "3462185546", "1122 Boogeyman St, Houston, TX");
        if (contact.getLastName().length() > 10) {
            fail("Last Name had more than 10 characters.");
        }
    }

    @Test
    @DisplayName("Contact phone number needed to be exactly 10 characters.")
    void testContactNumberWithMoreThanTenCharacters() {
        Contact contact = new Contact("John", "Smith", "12345678900", "1122 Boogeyman St, Houston, TX");
        if (contact.getNumber().length() != 10) {
            fail("Phone number length did not equal 10.");
        }
    }

    @Test
    @DisplayName("Contact address could not have more than 30 characters.")
    void testContactAddressWithMoreThanThirtyCharacters() {
        Contact contact = new Contact("John", "Smith", "3462185546",
                "This address was way too long to be valid for a contact entry.");
        if (contact.getAddress().length() > 30) {
            fail("Address had more than 30 characters.");
        }
    }

    @Test
    @DisplayName("Contact First Name was not null.")
    void testContactFirstNameNotNull() {
        Contact contact = new Contact(null, "Smith", "3462185546", "1122 Boogeyman St, Houston, TX");
        assertNotNull(contact.getFirstName(), "First name was null.");
    }

    @Test
    @DisplayName("Contact Last Name was not null.")
    void testContactLastNameNotNull() {
        Contact contact = new Contact("John", null, "3462185546", "1122 Boogeyman St, Houston, TX");
        assertNotNull(contact.getLastName(), "Last name was null.");
    }

    @Test
    @DisplayName("Contact Phone Number was not null.")
    void testContactPhoneNotNull() {
        Contact contact = new Contact("John", "Smith", null, "1122 Boogeyman St, Houston, TX");
        assertNotNull(contact.getNumber(), "Phone number was null.");
    }

    @Test
    @DisplayName("Contact Address was not null.")
    void testContactAddressNotNull() {
        Contact contact = new Contact("John", "Smith", "3462185546", null);
        assertNotNull(contact.getAddress(), "Address was null.");
    }
}
