package controller.oder;

import java.awt.event.ItemEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.CartItem;

public class ShoppingCart {
/*	Map<Integer, CartItem> maps = new HashMap<>();// giỏ hàng
//	public void add(CartItem cart) {
//		CartItem c = maps.get(cart.getCartId());
//		if(c == null) {
//			// chưa có trong giỏ hàng
//			maps.put(cart.getCartId(), cart);
//		}
//		else {
//			cart.setQuantity(cart.getQuantity()+1);
//			maps.put(cart.getCartId(), cart);
//		}
//	}
	public void remove(int id) {
		maps.remove(id);
	}
	public CartItem update(int cartId, int qty) {
		CartItem cart = maps.get(cartId);
		cart.setQuantity(qty);
		return cart;
	}
	public void clear() {
		maps.clear();
	}
	
	
	public Collection<CartItem> getAllCart(){
		return maps.values();
	}
	
	public int getCount() {
		return maps.values().size();
	}
	public long getAmount() {
		return maps.values().stream().mapToLong(item -> item.getQuantity() * item.getPriceNew()).sum();
	}
	*/
}
