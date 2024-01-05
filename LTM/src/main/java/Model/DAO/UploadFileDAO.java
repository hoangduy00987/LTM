package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.BEAN.User;


public class UploadFileDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3307/ltm";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456789";
    boolean isExist = false;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public boolean uploadFile(String slug, String idUser) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "INSERT INTO file (slug, id_user) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, slug);
            stmt.setString(2, idUser);
            int row = stmt.executeUpdate();
            if (row > 0) {
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
        }

        return isExist;
    }
   

}
