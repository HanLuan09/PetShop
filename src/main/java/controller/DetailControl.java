package controller;

import java.io.IOException;
import java.util.*;

import controller.cart.CartSevice;
import model.*;
import dao.DAO;
import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailControl extends HttpServlet{
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
//    	lấy url
    	String previousUrl = (String) session.getAttribute("previousUrl");
    	if (previousUrl != null && !previousUrl.isEmpty()) {
    	    // Xóa URL trước đó khỏi session
    	    session.removeAttribute("previousUrl");
    	} 
//    	String previousNewUrl = request.getRequestURI();
    	String previousNewUrl = request.getRequestURI() + "?" + request.getQueryString();
    	session.setAttribute("previousUrl", previousNewUrl);
    	
//    	
        String id = request.getParameter("pid");
        String cateId = request.getParameter("cid");
        DAO dao = new DAO();
        ProductSortDao daoP = new ProductSortDao();
        List<ProductDetails> listP = daoP.getAllProductCid(cateId);
        Collections.sort(listP);
        Product p = dao.getProductById(id);
        List<Size> listSizes = dao.getSizes(id);
        List<Color> listColors = dao.getColors(id);
        List<Category> listC = dao.getAllCategory();
        int sum = dao.getNumberOfProductsSold(id);
        
        request.setAttribute("sumP", sum);
        request.setAttribute("detail", p);
        request.setAttribute("listCC", listC);
        request.setAttribute("listSize", listSizes);
        request.setAttribute("listColor", listColors);
        request.setAttribute("listP", listP);
        
        request.getRequestDispatcher("product_details.jsp").forward(request, response);
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
