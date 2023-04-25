package model;

import java.sql.Date;
import java.util.List;

public class Order {
	private int idO;
	private Date createdDate;
	private int idA;
//	private List<OrderDetails> listO;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int idO, Date createdDate, int idA) {
		super();
		this.idO = idO;
		this.createdDate = createdDate;
		this.idA = idA;
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
	
}
