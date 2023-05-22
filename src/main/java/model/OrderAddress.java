package model;

public class OrderAddress {

	private int idO;
	private String name;
	private String phone;
	private String address;
	
	public OrderAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderAddress(int idO, String name, String phone, String address) {
		super();
		this.idO = idO;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
