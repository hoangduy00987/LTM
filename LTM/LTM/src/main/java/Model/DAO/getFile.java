package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.BEAN.uploadfile;

public class getFile {
	private static final String DB_URL = "jdbc:mysql://localhost:3307/ltm";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "123456789";
	
	public uploadfile GetFile(int fid) {
	    uploadfile file = null;
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	        stmt = conn.createStatement();
	        String sql = "SELECT * FROM uploadfile WHERE fid = " + fid;
	        rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            String id = rs.getString("id_file");
	            String fname = rs.getString("slug");
	            
	            file = new uploadfile(id, fname);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    
	    return file;
	}

}
