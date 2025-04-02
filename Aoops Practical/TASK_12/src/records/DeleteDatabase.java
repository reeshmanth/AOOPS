package records;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class DeleteDatabase {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP DATABASE IF EXISTS StudentDB");
            System.out.println("Database deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

