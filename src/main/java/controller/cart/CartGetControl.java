package controller.cart;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.ProductDetails;

@WebServlet(name = "CartGetControl", urlPatterns = {"/cart-get"})
public class CartGetControl extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	xem giỏ hàng của tài khoản nào
    	HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account==null) {
    		response.sendRedirect("login");
    	}else {
    		
    		ProductSortDao daoP = new ProductSortDao();
    		List<ProductDetails> listP = daoP.getAllProductSumPrice();
    		Collections.sort(listP);
    		
    		CartSevice cartSevice = new CartSevice();
    		List<CartItem> listCartItems = cartSevice.getCartItemsFromCookiesAccount(account.getIdA(), request);
    		
    		request.setAttribute("listP", listP);
    		request.setAttribute("listCart", listCartItems);
    		request.getRequestDispatcher("cart.jsp").forward(request, response); // Chuyển hướng đến trang giỏ hàng
    	}
    }
}


