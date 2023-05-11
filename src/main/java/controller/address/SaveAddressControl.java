package controller.address;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
import model.CartItem;
import model.Order;
import model.OrderDetails;
import model.Product;
import sevice.CartSevice;

@WebServlet(name="SaveAddressControl", urlPatterns = {"/save-address"})
public class SaveAddressControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        
    }  
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {	
    		response.sendRedirect("login");
    	}
    	int idA = a.getIdA();
    	try { 
    		String name = request.getParameter("name");
    		String phone = request.getParameter("phone");
    		String nameAddress = request.getParameter("address");
    		AccountDao daoAccount = new AccountDao();
    		daoAccount.updateAddress(idA, name, phone, nameAddress);
    		String ipPSession = (String)session.getAttribute("pay-idp");
        	String quantitySession = (String)session.getAttribute("pay-quantity");
        	if(ipPSession!=null && quantitySession!=null) {
        		response.sendRedirect("/petshop/petshop-orders?idp="+ipPSession+"&quantity="+quantitySession);
        	}
        	else {
        		response.sendRedirect("/petshop/petshop-orders");
        	}
		} catch (Exception e) {
			request.setAttribute("messAddress", "Không thể thay đổi địa chỉ!");
			request.getRequestDispatcher("address").forward(request, response);
		}
    	
    }

}

