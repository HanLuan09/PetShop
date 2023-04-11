package controller.cart;

import java.io.IOException;
import java.util.List;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Account;
import model.CartItem;
import model.Product;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart-add"})
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	DAO dao= new DAO();
    	CartSevice cartSevice = new CartSevice();
//    	xem giỏ hàng của tài khoản nào
    	HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account == null) {
    		response.sendRedirect("login");
    	}else {
    		
    		int idP = Integer.parseInt(request.getParameter("idp"));
    		int quantity = Integer.parseInt(request.getParameter("quantity"));
    		Product product = dao.getProductById(idP+"");
    		if (product == null) {
    			response.sendRedirect("error.jsp");
    			return;
    		}
    		
//        Lấy danh sách sản phẩm trong giỏ hàng từ cookie
    		List<CartItem> cartItems =cartSevice.getCartItemsFromCookies(request);
//        Tìm kiếm sản phẩm trong danh sách sản phẩm trong giỏ hàng
    		CartItem cartItem = cartSevice.findCartItem(cartItems, idP, account.getIdA());
    		if (cartItem == null) {
//            Nếu sản phẩm chưa có trong giỏ hàng, tạo mới đối tượng CartItem
    			cartItem = new CartItem(product, quantity, account.getIdA());
    			cartItems.add(cartItem);
    		} else {
//            Nếu sản phẩm đã có trong giỏ hàng, cập nhật số lượng
    			cartItem.setQuantity(cartItem.getQuantity() + quantity);
    		}
//        Lưu danh sách sản phẩm trong giỏ hàng vào cookie
    		cartSevice.saveCartItemsToCookies(response, cartItems);
    		request.setAttribute("listCart", cartItems);
    		response.sendRedirect("detail?pid="+product.getIdP()+"&cid="+product.getCateId()); // Chuyển hướng đến trang giỏ hàng
    	}
    }
}
