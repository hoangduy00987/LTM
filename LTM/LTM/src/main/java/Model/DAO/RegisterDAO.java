package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/ltm";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456789";

    public boolean registerUser(String fullname, String address, String phone_number, String email, String username, String password, String role) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String insertQuery = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException ex) {
            System.out.println("MySQL JDBC driver not found.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("An unexpected error occurred.");
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
}