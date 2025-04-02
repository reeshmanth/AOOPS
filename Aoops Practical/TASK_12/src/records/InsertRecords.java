package records;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertRecords {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Registration (id, name, address, program) VALUES (?, ?, ?, ?)");) {
            
            pstmt.setInt(1, 100);
            pstmt.setString(2, "Reeshmanth");
            pstmt.setString(3, "Hyderabad");
            pstmt.setString(4, "Computer Science");
            pstmt.executeUpdate();
            
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Sasank");
            pstmt.setString(3, "Mumbai");
            pstmt.setString(4, "Mechanical Engineering");
            pstmt.executeUpdate();
            
            pstmt.setInt(1, 102);
            pstmt.setString(2, "Kusumitha");
            pstmt.setString(3, "Chennai");
            pstmt.setString(4, "Electrical Engineering");
            pstmt.executeUpdate();
            
            pstmt.setInt(1, 103);
            pstmt.setString(2, "Sathvik");
            pstmt.setString(3, "Pakistan");
            pstmt.setString(4, "Civil Engineering");
            pstmt.executeUpdate();
            
            System.out.println("Records inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}