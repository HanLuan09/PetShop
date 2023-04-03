package model;

public class Account {
	private int idA;
	private String username;
	private String password;
	private int isAdmin;
	public Account() {
		
	}

	public Account(int idA, String username, String password, int isAdmin) {
		this.idA = idA;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}

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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
