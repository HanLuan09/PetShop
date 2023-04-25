package model;

import java.util.List;

public class CartItem{
	private Product product;
	private int quantity;
	private int idA;
	public CartItem(Product product, int quantity, int idA) {
		
		this.product = product;
		this.quantity = quantity;
		this.idA = idA;
	}
	public CartItem() {
		
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public int getCountP(List<CartItem> list) {
		return list.size();
	}
	
	public long getSumPrice(List<CartItem> list) {
		long sumPrice = 0;
		for(CartItem o: list) {
			sumPrice = sumPrice + (o.getQuantity() * o.getProduct().getPriceNew());
		}
		return sumPrice;
	}
	
}
