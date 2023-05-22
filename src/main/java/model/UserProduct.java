package model;

import java.sql.Date;

public class UserProduct implements Comparable<UserProduct>{
	private int idP;
	private int idO;
	private String nameP;
	private String imageP;
	private Date date;
	private int status;
	private int price;
	private int amount;
	public UserProduct() {
	}
	public UserProduct(int idP, int idO, String nameP, String imageP, Date date, int status, int price, int amount) {
		super();
		this.idP = idP;
		this.idO = idO;
		this.nameP = nameP;
		this.imageP = imageP;
		this.date = date;
		this.status = status;
		this.price = price;
		this.amount = amount;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public int getIdO() {
		return idO;
	}
	public void setIdO(int idO) {
		this.idO = idO;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int compareTo(UserProduct o) {
		return Integer.compare(o.idO, this.idO);
	}
}
