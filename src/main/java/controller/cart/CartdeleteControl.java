package controller.cart;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import sevice.CartSevice;

@WebServlet(name = "CartdeleteControl", urlPatterns = {"/cart-delete"})
public class CartdeleteControl extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	xem giỏ hàng của tài khoản nào
    	HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account==null) {
    		response.sendRedirect("login");
    	}else {
    		try {
    			int idP = Integer.parseInt(request.getParameter("idp"));
    			int idA = Integer.parseInt(request.getParameter("ida"));
    			int idcheck = Integer.parseInt(request.getParameter("idcheck"));
    			CartSevice cartSevice = new CartSevice();
    			cartSevice.removeCartItemFromCookies(idP, idA, response, request);
//    		request.getRequestDispatcher("card-get").forward(request, response);
    			if(idcheck == 1) {
    				response.sendRedirect("cart-get");
    			}
    			else {
    				response.sendRedirect("home");
    			}
				
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
    	}
    } 
}



