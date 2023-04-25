package model;

public class Account {
	private int idA;
	private String imageA;
	private String username;
	private String password;
	private int isAdmin;
	public Account() {
		
	}
	
	public Account(int idA, String imageA, String username, String password, int isAdmin) {
		super();
		this.idA = idA;
		this.imageA = imageA;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getImageA() {
		return imageA;
	}

	public void setImageA(String imageA) {
		this.imageA = imageA;
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
