package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.BEAN.Wife;



public class checkLoginDAO {
public boolean isExitUser(String username, String password) {
	  
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/login", "root", "123456789");
	        Statement sm = conn.createStatement();
	        String sql = "SELECT * FROM login";
	        ResultSet rs = sm.executeQuery(sql);
	        while (rs.next()) {
	            if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
	                return true;
	                
	            }
	            
	        }
	        rs.close();
	        sm.close();
	        conn.close();
	    }catch (ClassNotFoundException ex) {
	        System.out.println("MySQL JDBC driver not found.");
	        ex.printStackTrace();
	    } catch (SQLException ex) {
	        System.out.println("An error occurred while connecting to the database.");
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        System.out.println("An unexpected error occurred.");
	        ex.printStackTrace();
	    }
	    return false;
	}
public ArrayList<Wife> getWifeList(String username){
	ArrayList<Wife> result = new ArrayList<Wife>();
	//connect database
	Wife wife = new Wife();
	wife.setName("hoangduy");
	wife.setAddress("Quang Binh");
	wife.setAlive(true);
	result.add(wife);
	
	wife  = new Wife();
	wife.setName("hoangduy00987");
	wife.setAddress("Da nang");
	wife.setAlive(true);
	result.add(wife);
	return result;
}
}
