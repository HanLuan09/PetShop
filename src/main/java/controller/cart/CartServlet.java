package controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Account;
import model.CartItem;
import model.Product;
import sevice.CartSevice;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart-add"})
public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
//        Lưu vào giỏ hàng
        CartSevice cartSevice = new CartSevice();
        //    	xem giỏ hàng của tài khoản nào
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            response.sendRedirect("login");
        } else {
        	
        	try {
        		int idP = Integer.parseInt(request.getParameter("idp"));
        		int quantity = Integer.parseInt(request.getParameter("quantity"));
        		Product product = dao.getProductById(idP + "");
        		if (product == null) {
        			request.getRequestDispatcher("error.jsp").forward(request, response);
        		}
        		
        		// Lấy danh sách sản phẩm trong giỏ hàng từ cookie
        		// xử lý try catch khi cookies ko có
        		List<CartItem> cartItems = null;
        		try {
        			cartItems = cartSevice.getCartItemsFromCookies(request);
        		} catch (Exception e) {
        			cartItems = new ArrayList<>();
        		}
        		// Kiểm tra null trước khi thêm sản phẩm vào giỏ hàng
        		if (cartItems == null) {
        			cartItems = new ArrayList<>();
        		}
        		// Tìm kiếm sản phẩm trong danh sách sản phẩm trong giỏ hàng
        		CartItem cartItem = cartSevice.findCartItem(cartItems, idP, account.getIdA());
        		if (cartItem == null) {
        			// Nếu sản phẩm chưa có trong giỏ hàng, tạo mới đối tượng CartItem
        			cartItems.add(new CartItem(product, quantity, account.getIdA()));
        		} else {
        			// Nếu sản phẩm đã có trong giỏ hàng, cập nhật số lượng
        			int checkRem = dao.remainingProducts(idP);
        			if(cartItem.getQuantity() + quantity >= checkRem) {
        				cartItem.setQuantity(checkRem);
        			}else {	
        				cartItem.setQuantity(cartItem.getQuantity() + quantity);
        			}
        		}
        		// Lưu danh sách sản phẩm trong giỏ hàng vào cookie
        		cartSevice.saveCartItemsToCookies(response, cartItems);
        		request.setAttribute("listCart", cartItems);
        		response.sendRedirect("detail?pid=" + product.getIdP() + "&cid=" + product.getCateId()); // Chuyển hướng đến trang giỏ hàng
        	
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
        }
    }
}