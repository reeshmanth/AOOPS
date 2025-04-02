package records;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateRecords {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE Registration SET program=? WHERE id=?")) {
            
            pstmt.setString(1, "Software Engineering");
            pstmt.setInt(2, 100);
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Aerospace Engineering");
            pstmt.setInt(2, 101);
            pstmt.executeUpdate();
            
            System.out.println("Records updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
