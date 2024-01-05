package Model.BEAN;

public class User {
	public String id;
	
	public String username;
	public String password;
	public String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public String getId() {
		return id;
	}
	public void setId(String iduser) {
		this.id = iduser;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User() {
		super();
		
	}
	

}
