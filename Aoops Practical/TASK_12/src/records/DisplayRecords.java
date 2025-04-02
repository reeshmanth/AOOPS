package records;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DisplayRecords {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM Registration")) {
            System.out.println("\nStudent Records:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Address: " + rs.getString("address") +
                                   ", Program: " + rs.getString("program"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}