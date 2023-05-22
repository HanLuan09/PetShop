package model;

import java.sql.Date;
import java.util.List;

public class Payment {
	private int idO;
	private String bankcode;
	private long priceBank;
	private long priceSum;
	private String orderInfo;
	private Date payDate;
	public Payment() {
		
	}
	public Payment(int idO, String bankcode, long priceBank, long priceSum, String orderInfo, Date payDate) {
		super();
		this.idO = idO;
		this.bankcode = bankcode;
		this.priceBank = priceBank;
		this.priceSum = priceSum;
		this.orderInfo = orderInfo;
		this.payDate = payDate;
	}
	public int getIdO() {
		return idO;
	}
	public String getBankcode() {
		return bankcode;
	}
	public long getPriceBank() {
		return priceBank;
	}
	public long getPriceSum() {
		return priceSum;
	}
	public String getOrderInfo() {
		return orderInfo;
	}
	public Date getPayDate() {
		return payDate;
	}
	public long sumOrderPrice(List<Payment> list) {
		long sum = 0;
		for(Payment o: list) {
			sum += o.priceBank;
		}
		return sum;
	}
}
