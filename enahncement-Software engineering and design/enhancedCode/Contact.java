/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-499
 * Date:  January 26, 2026
 *************************/

import java.util.concurrent.atomic.AtomicLong;

/*
 * Contact class
 * This class represents a single contact.
 * It stores contact information and makes sure the data is valid.
 */
public class Contact {

    // Constants used for validation rules
    private static final int MAX_NAME_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 30;
    private static final int PHONE_LENGTH = 10;

    // Atomic counter used to generate unique contact IDs
    private static final AtomicLong idGenerator = new AtomicLong();

    // Contact fields
    private final String contactID;     // ID should never change once created
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    /*
     * Constructor
     * Creates a new contact and validates all input values.
     * If any value is invalid, an exception is thrown.
     */
    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = String.valueOf(idGenerator.getAndIncrement());
        this.firstName = validateName(firstName, "First name");
        this.lastName = validateName(lastName, "Last name");
        this.phoneNumber = validatePhone(phoneNumber);
        this.address = validateAddress(address);
    }

    /*
     * Helper method to validate first and last names
     */
    private String validateName(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(fieldName + " cannot exceed " + MAX_NAME_LENGTH + " characters");
        }
        return value;
    }

    /*
     * Helper method to validate phone number
     * Phone number must be exactly 10 digits
     */
    private String validatePhone(String value) {
        if (value == null || !value.matches("\\d{" + PHONE_LENGTH + "}")) {
            throw new IllegalArgumentException("Phone number must be exactly " + PHONE_LENGTH + " digits");
        }
        return value;
    }

    /*
     * Helper method to validate address
     */
    private String validateAddress(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (value.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address cannot exceed " + MAX_ADDRESS_LENGTH + " characters");
        }
        return value;
    }

    // Getters (read-only access to fields)

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters (validate input before updating values)

    public void setFirstName(String firstName) {
        this.firstName = validateName(firstName, "First name");
    }

    public void setLastName(String lastName) {
        this.lastName = validateName(lastName, "Last name");
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = validatePhone(phoneNumber);
    }

    public void setAddress(String address) {
        this.address = validateAddress(address);
    }
}
