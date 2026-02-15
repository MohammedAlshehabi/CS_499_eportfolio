/*************************
 * Name:  Mohammed Alshehabi
 * Course:  CS-320
 * Date:  January 26, 2025
 * Description: This was the contact class. It created and stored contact information.
 *************************/



import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String number;
    private String address;
    private static AtomicLong idGenerator = new AtomicLong();

    // Constructor
    /*
     * This constructor created a new contact with details like name, phone number, and address.
     * It ensured the provided details were valid, not too long or empty.
     */
    public Contact(String firstName, String lastName, String number, String address) {
        this.contactID = String.valueOf(idGenerator.getAndIncrement());

        // First Name
        if (firstName == null || firstName.isEmpty()) {
            this.firstName = "NULL";
        } else if (firstName.length() > 10) {
            this.firstName = firstName.substring(0, 10);
        } else {
            this.firstName = firstName;
        }

        // Last Name
        if (lastName == null || lastName.isEmpty()) {
            this.lastName = "NULL";
        } else if (lastName.length() > 10) {
            this.lastName = lastName.substring(0, 10);
        } else {
            this.lastName = lastName;
        }

        // Number
        if (number == null || number.isEmpty() || number.length() != 10) {
            this.number = "9999999999";
        } else {
            this.number = number;
        }

        // Address
        if (address == null || address.isEmpty()) {
            this.address = "NULL";
        } else if (address.length() > 30) {
            this.address = address.substring(0, 30);
        } else {
            this.address = address;
        }
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            this.firstName = "NULL";
        } else if (firstName.length() > 10) {
            this.firstName = firstName.substring(0, 10);
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            this.lastName = "NULL";
        } else if (lastName.length() > 10) {
            this.lastName = lastName.substring(0, 10);
        } else {
            this.lastName = lastName;
        }
    }

    public void setNumber(String number) {
        if (number == null || number.isEmpty() || number.length() != 10) {
            this.number = "9999999999";
        } else {
            this.number = number;
        }
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            this.address = "NULL";
        } else if (address.length() > 30) {
            this.address = address.substring(0, 30);
        } else {
            this.address = address;
        }
    }
}
