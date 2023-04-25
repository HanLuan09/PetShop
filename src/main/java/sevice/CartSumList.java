package sevice;

import java.util.List;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;

public class CartSumList {
	public void viewCart (HttpServletRequest request) {
//      hiển thị cart  
        HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account == null) {
    		request.setAttribute("sumCart", 0);
    	}else {
    		CartSevice cartSevice = new CartSevice();
    		Cookie[] cookies = request.getCookies();
    		int check = 0;
    		if(cookies!= null) {
    			for(Cookie cookie : cookies) {
    				if (cookie.getName().equals("cart-petshop")) {
    					check=1;
    				}
    			}
    		}
    		try {
    			List<CartItem> listCartItems = cartSevice.getCartItemsFromCookiesAccount(account.getIdA(), request);
    			request.setAttribute("sumCart", listCartItems.size());
    			request.setAttribute("listCartNavi", listCartItems);
    		}catch (Exception e) {
    			request.setAttribute("sumCart", 0);
    		}
    		
    	}
	}
	
}
