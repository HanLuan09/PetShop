package model;

public class UserProductDetail {
	private int idP;
	private String nameP;
	private String origin;
	private int idO;
	private int amount;
	private int price;
	private String imageP;
	private long sumPrice;
	private int status;
	public UserProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProductDetail(int idP, String nameP, String origin, int idO, int amount, int price, String imageP, int status) {
		super();
		this.idP = idP;
		this.nameP = nameP;
		this.origin = origin;
		this.idO = idO;
		this.amount = amount;
		this.price = price;
		this.sumPrice = this.price*this.amount;
		this.imageP = imageP;
		this.status = status;
	}
	public int getIdP() {
		return idP;
	}
	
	public String getNameP() {
		return nameP;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public int getIdO() {
		return idO;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getPrice() {
		return price;
	}
	public long getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(long sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getImageP() {
		return imageP;
	}
	public void setImageP(String imageP) {
		this.imageP = imageP;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
