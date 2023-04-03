package model;

public class Address {
	private int id, idA;
	private String name;
	private String phone;
	private String address;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, int idA, String name, String phone, String address) {
		super();
		this.id = id;
		this.idA = idA;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
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
	@Override
	public String toString() {
		return "Address [id=" + id + ", idA=" + idA + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
}
