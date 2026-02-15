import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:contacts.db";

    static {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Drop annd recreate table to ensuring a clean state for tests
            stmt.execute("DROP TABLE IF EXISTS Contacts;");

            stmt.execute("""
                CREATE TABLE Contacts (
                    contact_id TEXT PRIMARY KEY NOT NULL,
                    first_name TEXT NOT NULL CHECK(LENGTH(first_name) <= 10),
                    last_name TEXT NOT NULL CHECK(LENGTH(last_name) <= 10),
                    phone_number TEXT NOT NULL CHECK(LENGTH(phone_number) = 10),
                    address TEXT NOT NULL CHECK(LENGTH(address) <= 30)
                );
            """);


            stmt.execute("CREATE INDEX idx_contacts_phone ON Contacts(phone_number);");

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }
}
