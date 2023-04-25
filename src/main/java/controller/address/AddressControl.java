package controller.address;

import java.io.IOException;
import dao.AccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Address;

@WebServlet(name="AddressControl", urlPatterns = {"/address"})
public class AddressControl extends HttpServlet {
	
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
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
	    		request.setAttribute("addressCheck", check);
	    		request.setAttribute("address", aRess);
	    		request.getRequestDispatcher("address.jsp").forward(request, response);
    		} catch (Exception e) {
				// TODO: handle exception
			}
	
    	}
    	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	
        
    }  

}
