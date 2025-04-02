package records;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteRecords {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Registration WHERE id=?")) {
            
            pstmt.setInt(1, 101);
            pstmt.executeUpdate();
            
            System.out.println("Record deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}