package jdbcapi;

import java.sql.*;

public class JDBCExample {
	private static final String URL = "jdbc:postgresql://localhost:5432/testdb";
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";


    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");

            insertUser(conn, "Reeshmanth", "reeshmanth@gmail.com");
            insertUser(conn, "Sathvik", "sathvik@gmail.com");

            readUsers(conn);

            updateUserEmail(conn, 1, "reeshmanth8055@gmail.com");

            deleteUser(conn, 2);

            conn.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(Connection conn, String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            int rows = stmt.executeUpdate();
            System.out.println("Inserted " + rows + " row(s): " + name + " - " + email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readUsers(Connection conn) {
        String sql = "SELECT * FROM users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Users List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUserEmail(Connection conn, int userId, String newEmail) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, userId);
            int rows = stmt.executeUpdate();
            System.out.println("Updated " + rows + " row(s) for user ID " + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(Connection conn, int userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            int rows = stmt.executeUpdate();
            System.out.println("Deleted " + rows + " row(s) for user ID " + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

