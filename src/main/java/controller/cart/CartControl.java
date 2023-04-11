package controller.cart;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CartItem;

@WebServlet(name = "CartControl", urlPatterns = {"/cart-save"})
public class CartControl extends HttpServlet{
/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	CartSevice cartSevice = new CartSevice();
    	 // Lấy danh sách sản phẩm trong giỏ hàng từ cookie
        List<CartItem> cartItems = cartSevice.getCartItemsFromCookies(request);
        int idP = Integer.parseInt(request.getParameter("idp"));
        // Tìm kiếm sản phẩm trong danh sách sản phẩm trong giỏ hàng
        CartItem cartItem = cartSevice.findCartItem(cartItems, idP);
        if (cartItem != null) {
            // Nếu sản phẩm có trong giỏ hàng, xóa sản phẩm khỏi danh sách sản phẩm trong giỏ hàng
            cartItems.remove(cartItem);
        }
        // Lưu danh sách sản phẩm trong giỏ hàng vào cookie
        cartSevice.saveCartItemsToCookies(response, cartItems);
//        for(CartItem o: cartItems) {
//        	System.out.println(o);
//        }
        request.setAttribute("listCart", cartItems);
        request.getRequestDispatcher("cart.jsp").forward(request, response); // Chuyển hướng đến trang giỏ hàng
    }
    */
}

