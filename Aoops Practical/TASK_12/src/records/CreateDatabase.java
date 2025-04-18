package records;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE StudentDB");
            System.out.println("Database created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}