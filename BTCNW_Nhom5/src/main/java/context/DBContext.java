package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	 private static final String DB_URL = "jdbc:mysql://localhost:3307/data";
	    private static final String DB_USERNAME = "root";
	    private static final String DB_PASSWORD = "123456789";

	    public static Connection getConnection() throws ClassNotFoundException, SQLException {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    }
}
