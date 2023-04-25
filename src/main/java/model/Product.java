package model;


public class Product {
	private int idP;
	private String nameP;
	private String imageP;
	private String describe;
	private String origin;
	private int amount;
	private int discount;
	private int price;
	private int priceNew;
	private int cateId;
	public Product() {
		
	}
	public Product(int idP, String nameP, String imageP, String describe, String origin, int amount, int discount,
			int price, int cateId) {
		this.idP = idP;
		this.nameP = nameP;
		this.imageP = imageP;
		this.describe = describe;
		this.origin = origin;
		this.amount = amount;
		this.discount = discount;
		this.price = price;
		this.priceNew = (int) (this.price - (this.price * (this.discount / 100.0)));
		this.cateId = cateId;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getNameP() {
		return nameP;
	}
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	public String getImageP() {
		return imageP;
	}
	public void setImageP(String imageP) {
		this.imageP = imageP;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPriceNew() {
		return priceNew;
	}
	public void setPriceNew(int priceNew) {
		this.priceNew = priceNew;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	@Override
	public String toString() {
		return "Product [idP=" + idP + ", nameP=" + nameP + ", imageP=" + imageP + ", describe=" + describe
				+ ", origin=" + origin + ", amount=" + amount + ", discount=" + discount + ", price=" + price
				+ ", priceNew=" + priceNew + ", cateId=" + cateId + "]";
	}
	
	
}
