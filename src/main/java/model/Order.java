package model;

import java.sql.Date;
import java.util.List;

public class Order {
	private int idO;
	private Date createdDate;
	private int idA;
	private int status;
//	private List<OrderDetails> listO;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int idO, Date createdDate, int idA, int status) {
		super();
		this.idO = idO;
		this.createdDate = createdDate;
		this.idA = idA;
		this.status = status;
//		this.listO = listO;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

//	public List<OrderDetails> getListO() {
//		return listO;
//	}
//
//	public void setListO(List<OrderDetails> listO) {
//		this.listO = listO;
//	}

	
}
