package model;

public class AdminProduct implements Comparable<AdminProduct> {
	private int idP;
	private String nameP;
	private String cate;
	private int amount;
	private int price;
	private int discount;
	private int sumPrice;
	
	public AdminProduct() {
		
	}

	public AdminProduct(int idP, String nameP, String cate, int amount, int price, int discount, int sumPrice) {
		super();
		this.idP = idP;
		this.nameP = nameP;
		this.cate = cate;
		this.amount = amount;
		this.price = price;
		this.discount = discount;
		this.sumPrice = sumPrice;
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

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public int compareTo(AdminProduct o) {
		return o.idP -this.idP;
	}
	@Override
	public String toString() {
		return "AdminProduct [idP=" + idP + ", nameP=" + nameP + ", cate=" + cate + ", amount=" + amount + ", price="
				+ price + ", sumPrice=" + sumPrice + "]";
	}
	
}
