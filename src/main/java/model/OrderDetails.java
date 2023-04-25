package model;

public class OrderDetails {
	private int idO;
	private int idP;
	private int amount;
	private int price;
	private int status;
	public OrderDetails() {
	}

	public OrderDetails(int idO, int idP, int amount, int price, int status) {
		super();
		this.idO = idO;
		this.idP = idP;
		this.amount = amount;
		this.price = price;
		this.status = status;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
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
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetails [idO=" + idO + ", idP=" + idP + ", amount=" + amount + ", price=" + price + "]";
	}
	
}
