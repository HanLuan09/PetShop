package controller.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.DAO;
import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.CartItemSum;
import model.ProductDetails;
import sevice.CartSevice;
import sevice.CartSumList;

@WebServlet(name = "CartGetControl", urlPatterns = {"/cart-get"})
public class CartGetControl extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
//    	xem giỏ hàng của tài khoản nào
        
    	HttpSession session = request.getSession();
    	session.removeAttribute("pay-idp");
        session.removeAttribute("pay-quantity");
    	Account account = (Account) session.getAttribute("account");
    	if(account==null) {
    		response.sendRedirect("login");
    	}else {
    		try {
				
    			CartItem cartItem = new CartItem();
    			DAO dao = new DAO();
    			ProductSortDao daoP = new ProductSortDao();
    			List<ProductDetails> listP = daoP.getAllProductSumPrice();
    			Collections.sort(listP);
    			
    			CartSevice cartSevice = new CartSevice();
    			List<CartItem> listCartItems;
    			try {
    				listCartItems = cartSevice.getCartItemsFromCookiesAccount(account.getIdA(), request);
    			}catch (Exception e) {
    				listCartItems = new ArrayList<>();
    			}
    			
    			List<CartItemSum> liItemSums = new ArrayList<>();
    			for(CartItem o : listCartItems) {
    				int remaining = dao.remainingProducts(o.getProduct().getIdP());
    				liItemSums.add(new CartItemSum(o, remaining));
    			}
    			request.setAttribute("listP", listP);
    			request.setAttribute("listCart", liItemSums);
    			request.setAttribute("checkCItem", listCartItems.size());
    			request.setAttribute("countP", cartItem.getCountP(listCartItems));
    			request.setAttribute("sumPrice", cartItem.getSumPrice(listCartItems));
    			request.getRequestDispatcher("cart.jsp").forward(request, response); // Chuyển hướng đến trang giỏ hàng
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
    	}
    }
}


