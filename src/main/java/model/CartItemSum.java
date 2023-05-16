package model;

public class CartItemSum {
	private CartItem cartItem;
	private int remaining;
	
	public CartItemSum() {
		
	}

	public CartItemSum(CartItem cartItem, int remaining) {
		this.cartItem = cartItem;
		this.remaining = remaining;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public int getRemaining() {
		return remaining;
	}
	
}
