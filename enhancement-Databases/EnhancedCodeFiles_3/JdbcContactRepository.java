import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcContactRepository implements ContactRepository {



    @Override
    public void create(Contact contact) {
        String sql = "INSERT INTO Contacts (contact_id, first_name, last_name, phone_number, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getContactID());
            stmt.setString(2, contact.getFirstName());
            stmt.setString(3, contact.getLastName());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5, contact.getAddress());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create contact", e);
        }
    }

    @Override
    public Optional<Contact> findById(String id) {
        String sql = "SELECT * FROM Contacts WHERE contact_id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(mapRow(rs));
            }
            return Optional.empty();

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch contact", e);
        }
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> results = new ArrayList<>();
        String sql = "SELECT * FROM Contacts";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                results.add(mapRow(rs));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch contacts", e);
        }
        return results;
    }

    @Override
    public void update(Contact contact) {
        String sql = "UPDATE Contacts SET first_name = ?, last_name = ?, phone_number = ?, address = ? WHERE contact_id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getAddress());
            stmt.setString(5, contact.getContactID());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to update contact", e);
        }
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM Contacts WHERE contact_id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact", e);
        }
    }

    /**
     *  mapRow uses the 5-argument constructor
     * so the contact ID is preserved from the database.
     */
    private Contact mapRow(ResultSet rs) throws SQLException {
        return new Contact(
                rs.getString("contact_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("phone_number"),
                rs.getString("address")
        );
    }

    /**
     Deletes all contacts from the database
     */
    public static void deleteAll() {
        String sql = "DELETE FROM Contacts";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete all contacts", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
