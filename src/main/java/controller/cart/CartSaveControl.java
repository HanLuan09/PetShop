package controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.Product;
import sevice.CartSevice;

@WebServlet(name = "CartSaveControl", urlPatterns = {"/cart-save"})
public class CartSaveControl extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	DAO dao= new DAO();
    	CartSevice cartSevice = new CartSevice();
//    	xem giỏ hàng của tài khoản nào
    	HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account == null) {
    		response.sendRedirect("login");
    	}else {
    		
    		try {
    			int idP = Integer.parseInt(request.getParameter("idp"));
    			int quantity = Integer.parseInt(request.getParameter("quantity"));
    			Product product = dao.getProductById(idP+"");
    			if (product == null) {
    				PrintWriter out = response.getWriter();
    				out.println("lỗi");
    			}
    			
//        Lấy danh sách sản phẩm trong giỏ hàng từ cookie
//    		xử lý try catch khi cookies ko có
    			List<CartItem> cartItems;
    			try {
    				cartItems =cartSevice.getCartItemsFromCookies(request);
    			}catch (Exception e) {
    				cartItems = new ArrayList<>();
    			}
//        Tìm kiếm sản phẩm trong danh sách sản phẩm trong giỏ hàng
    			CartItem cartItem = cartSevice.findCartItem(cartItems, idP, account.getIdA());
    			
    			int checkRem = dao.remainingProducts(idP);
    			if(quantity > checkRem || quantity < 1) {
    				response.sendRedirect("cart-get");
    			}
    			else{
	    			if(quantity>0 && quantity <= checkRem) cartItem.setQuantity(quantity);
	    			cartSevice.saveCartItemsToCookies(response, cartItems);
	    			request.setAttribute("listCart", cartItems);
	    			response.sendRedirect("cart-get");
    			}
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
    	}
    }
}

