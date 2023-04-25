package model;

import java.sql.Date;

public class UserProduct {
	private int idP;
	private int idO;
	private String nameP;
	private Date date;
	private int status;
	
	public UserProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProduct(int idP, int idO, String nameP, Date date, int status) {
		super();
		this.idP = idP;
		this.idO = idO;
		this.nameP = nameP;
		this.date = date;
		this.status = status;
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
	
}
