package model;

public class Cart {
	private Product product;
	private String size;
	private String color;
	private int quantity;
	
	public Cart() {
		
	}

	public Cart(Product product, String size, String color, int quantity) {
		this.product = product;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}
	
}
