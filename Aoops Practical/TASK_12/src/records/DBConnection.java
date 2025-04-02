package records;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
	static final String URL = "jdbc:postgresql://localhost:5432/studentdb";

    static final String USER = "postgres";
    static final String PASSWORD = "1234";

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
