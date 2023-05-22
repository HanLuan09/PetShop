package controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDao;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.CartItem;
import model.Product;
import model.ProductDetails;
import sevice.CartSevice;

@WebServlet(urlPatterns = "/petshop-orders")
public class OrderControl extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	Hiển thị danh sách sản phẩm muốn đặt
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    		return;
    	}
    	else {
    		try {
    			
	    		int idA = a.getIdA();
	    		AccountDao daoAccount = new AccountDao();
	    		Address aRess = daoAccount.getAddress(idA);
	    		int check = 1;
	    		if(aRess == null) {
	    			aRess = new Address();
	    			check=0;
	    		}
	    		
	    		CartItem cartItem = new CartItem();
//	    		lấy danh sách sản phẩm
	    		List<CartItem> listCartItems = new ArrayList<>();
	    		String ipP = request.getParameter("idp");
            	String quantity = request.getParameter("quantity");
            	
            	if(ipP!=null && quantity!=null) {
            		session.setAttribute("pay-idp", ipP);
            		session.setAttribute("pay-quantity", quantity);
            		DAO dao = new DAO();
            		Product product = dao.getProductById(ipP);	
            		listCartItems.add(new CartItem(product,  Integer.parseInt(quantity), idA));
            	}
            	
            	else {
            		CartSevice cartSevice = new CartSevice();
            		try {
            			listCartItems = cartSevice.getCartItemsFromCookiesAccount(a.getIdA(), request);
            		}catch (Exception e) {
            			listCartItems = new ArrayList<>();
            		}
            	}
//	    		
	    		String name ="";
	    		for(CartItem o: listCartItems) name = o.getProduct().getNameP();
	    		request.setAttribute("test", name);
	    		request.setAttribute("listCItem", listCartItems);
	    		request.setAttribute("sumPrice", cartItem.getSumPrice(listCartItems));
	    		request.setAttribute("addressCheck", check);
	    		request.setAttribute("address", aRess);
	    		request.getRequestDispatcher("order.jsp").forward(request, response);
    		} catch (Exception e) {
    			response.sendRedirect("error.jsp");
			}
	
    	}
    	
    }

}