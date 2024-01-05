package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class checkLoginDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3307/ltm";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "123456789";

	public boolean isExitUser(String username, String password, String role) {

		boolean isExist = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			String sql = "SELECT * FROM user WHERE  username = ? AND password = ? AND role = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, role);
			rs = stmt.executeQuery();
			if (rs.next()) {
				isExist = true;
			}

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
			// Đảm bảo đóng tài nguyên
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
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

		return isExist;
	}

	public String getIDUser(String username, String password, String role) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String iduser = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			String sql = "SELECT id FROM user WHERE  username = ? AND password = ? AND role = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, role);
			rs = stmt.executeQuery();
			while (rs.next()) {
				iduser = rs.getString("id");
				break;
			}

			return iduser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iduser;
	}


}
