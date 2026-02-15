/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 31, 2026
 *************************/

import java.util.concurrent.atomic.AtomicLong;

public class Contact {

    private static final int MAX_NAME_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 30;
    private static final int PHONE_LENGTH = 10;

    // Used only when creating NEW contacts
    private static final AtomicLong idGenerator = new AtomicLong();

    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    /**
     * Constructor used when CREATING a new contact
     * (ID is auto-generated)
     */
    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = String.valueOf(idGenerator.getAndIncrement());
        this.firstName = validateName(firstName, "First name");
        this.lastName = validateName(lastName, "Last name");
        this.phoneNumber = validatePhone(phoneNumber);
        this.address = validateAddress(address);
    }

    /**
     * Constructor used when LOADING a contact from storage
     * (ID is restored from database)
     */
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (contactID == null || contactID.isBlank()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty");
        }
        this.contactID = contactID;
        this.firstName = validateName(firstName, "First name");
        this.lastName = validateName(lastName, "Last name");
        this.phoneNumber = validatePhone(phoneNumber);
        this.address = validateAddress(address);
    }

    // ================= Validation Methods =================

    private String validateName(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    fieldName + " cannot exceed " + MAX_NAME_LENGTH + " characters");
        }
        return value;
    }

    private String validatePhone(String value) {
        if (value == null || !value.matches("\\d{" + PHONE_LENGTH + "}")) {
            throw new IllegalArgumentException(
                    "Phone number must be exactly " + PHONE_LENGTH + " digits");
        }
        return value;
    }

    private String validateAddress(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (value.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException(
                    "Address cannot exceed " + MAX_ADDRESS_LENGTH + " characters");
        }
        return value;
    }

    // ================= Getters =================

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // ================= Setters =================

    public void setFirstName(String firstName) {
        this.firstName = validateName(firstName, "First name");
    }

    public void setLastName(String lastName) {
        this.lastName = validateName(lastName, "Last name");
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = validatePhone(phoneNumber);
    }

    public void setAddress(String address) {
        this.address = validateAddress(address);
    }
}
