package model;

import java.sql.Date;
import java.util.List;

public class AccountProduct extends UserProduct {
	private int idA;

	public AccountProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountProduct(int idP, int idO, String nameP, String imageP, Date date, int status, int price, int amount, int idA) {
		super(idP, idO, nameP, imageP, date, status, price, amount);
		this.idA = idA;
	}

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}
	public long getSumPrice() {
		return this.getAmount()* this.getPrice();
	}
	public long getTongPrice(List<AccountProduct> list) {
		long sum = 0;
		for(AccountProduct o: list)  sum += o.getAmount()* o.getPrice();
		return sum;
	}
}
