package records;

import java.sql.Connection;
import java.sql.Statement;

public class SetupDatabase {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Registration ("
                + "id INT PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "address TEXT NOT NULL, "
                + "program TEXT NOT NULL"
                + ");";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

