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

    private static final AtomicLong idGenerator = new AtomicLong();

    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = String.valueOf(idGenerator.getAndIncrement());
        this.firstName = validateName(firstName, "First name");
        this.lastName = validateName(lastName, "Last name");
        this.phoneNumber = validatePhone(phoneNumber);
        this.address = validateAddress(address);
    }

    private String validateName(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(fieldName + " cannot exceed " + MAX_NAME_LENGTH + " characters");
        }
        return value;
    }

    private String validatePhone(String value) {
        if (value == null || !value.matches("\\d{" + PHONE_LENGTH + "}")) {
            throw new IllegalArgumentException("Phone number must be exactly " + PHONE_LENGTH + " digits");
        }
        return value;
    }

    private String validateAddress(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (value.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address cannot exceed " + MAX_ADDRESS_LENGTH + " characters");
        }
        return value;
    }

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
