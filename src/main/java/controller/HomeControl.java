package controller;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.Category;
import model.Product;
import model.ProductDetails;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import controller.cart.CartSevice;

@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//      hiển thị cart  
        HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account == null) {
    		request.setAttribute("sumCart", 0);
    	}else {
    		CartSevice cartSevice = new CartSevice();
    		List<CartItem> listCartItems = cartSevice.getCartItemsFromCookiesAccount(account.getIdA(), request);
    		request.setAttribute("sumCart", listCartItems.size());
    		request.setAttribute("listCartNavi", listCartItems);
    	}
//    	
        DAO dao = new DAO();
        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listCC", listC);
        List<ProductDetails> list = dao.getAllProductRemaining();
        List<Product> listDogCat = dao.getAllProductDogCat();
        Collections.sort(list);
//        //b2: set data to jsp
        request.setAttribute("listP", list);
        request.setAttribute("listDogCat", listDogCat);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        //404 -> url
        //500 -> jsp properties
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
