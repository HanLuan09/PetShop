package sevice;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CartItem;
import model.Product;

public class CartSevice {
	 	public List<CartItem> getCartItemsFromCookies(HttpServletRequest request) {
	        List<CartItem> cartItems = new ArrayList<>();
	        DAO dao = new DAO();
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("cart-petshop")) {
	                    String[] values = cookie.getValue().split("\\|");
	                    for (String value : values) {
	                        String[] parts = value.split("-");
	                        int idP = Integer.parseInt(parts[0]);
	                        int quantity = Integer.parseInt(parts[1]);
	                        int idA = Integer.parseInt(parts[2]);
	                        Product product = dao.getProductById(idP+"");
	                        if (product != null) {
	                            CartItem cartItem = new CartItem(product, quantity, idA);
	                            cartItems.add(cartItem); // Thêm đối tượng CartItem vào danh sách sản phẩm trong giỏ hàng
	                        }
	                    }
	                    return cartItems;
	                }
	            }
			}
		    return null;
	    }
//	 	list cart theo tài khoản
	 	public List<CartItem> getCartItemsFromCookiesAccount(int idA, HttpServletRequest request) {
	 		CartSevice cartSevice = new CartSevice();
	 		List<CartItem> listC = cartSevice.getCartItemsFromCookies(request);
	        List<CartItem> cartItems = new ArrayList<>();
	        for(CartItem o: listC) {
	        	if(o.getIdA()== idA) {
	        		cartItems.add(o);
	        	}
	        }
		    return cartItems;
	    }
//	 	list cart còn lại tài khoản
	 	public List<CartItem> getCartItemsFromCookiesNotAccount(int idA, HttpServletRequest request) {
	 		CartSevice cartSevice = new CartSevice();
	 		List<CartItem> listC = cartSevice.getCartItemsFromCookies(request);
	        List<CartItem> cartItems = new ArrayList<>();
	        for(CartItem o: listC) {
	        	if(o.getIdA()!= idA) {
	        		cartItems.add(o);
	        	}
	        }
		    return cartItems;
	    }
	 // Hàm để lưu danh sách sản phẩm trong giỏ hàng vào cookie
	    public void saveCartItemsToCookies(HttpServletResponse response, List<CartItem> cartItems) {
	        StringBuilder sb = new StringBuilder();
	        for (CartItem cartItem : cartItems) {
	            sb.append(cartItem.getProduct().getIdP())
	                    .append("-")
	                    .append(cartItem.getQuantity())
	                    .append("-")
	                    .append(cartItem.getIdA())
	                    .append("|");
	        }
	        if (sb.length() > 0) {
	            sb.deleteCharAt(sb.length() - 1);
	        }
	        Cookie cookie = new Cookie("cart-petshop", sb.toString());
	        cookie.setMaxAge(7*24 * 60 * 60); // Thời gian sống của cookie là 7 ngày
	        response.addCookie(cookie);
	    }

	    // Hàm để tìm kiếm sản phẩm trong danh sách sản phẩm trong giỏ hàng theo tài khoản
	    public CartItem findCartItem(List<CartItem> cartItems, int idP, int idA) {
	        for (CartItem cartItem : cartItems) {
	        	if(cartItem.getIdA()==idA) {
	        		if (cartItem.getProduct().getIdP() == idP) {
	        			return cartItem;
	        		}
	        	}
	        }
	        return null;
	    }
	    public void removeCookies(HttpServletResponse response) {
	    	 Cookie oldCookie = new Cookie("cart-petshop", "");
	         oldCookie.setMaxAge(0);
	         oldCookie.setPath("/");
	         response.addCookie(oldCookie);
	    }
	    public void removeCartItemFromCookies(int idP, int idA, HttpServletResponse response, HttpServletRequest request) {
	        List<CartItem> cartItems = getCartItemsFromCookies(request);
	        CartItem cartItemToRemove = findCartItem(cartItems, idP, idA);
	        if (cartItemToRemove != null) {
	            cartItems.remove(cartItemToRemove);
	            removeCookies(response);
	            saveCartItemsToCookies(response, cartItems);
	        }
	    }

}
