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
	//    	PrintWriter out = response.getWriter();
    		try {
	    		int idA = a.getIdA();
	    		AccountDao daoAccount = new AccountDao();
	    		Address aRess = daoAccount.getAddress(idA);
	    		if(aRess == null) aRess = new Address();
	    		request.setAttribute("address", aRess);
	    		request.getRequestDispatcher("address.jsp").forward(request, response);
    		} catch (Exception e) {
				// TODO: handle exception
			}
	//    	out.println("none");
	//    	if(a == null) {
	//    		out.println("none");
	//    	}
	//    	else {
	//    		out.println(a.getIdA());
	//    	}
	//        	response.sendRedirect("home");
    	}
    	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	
        
    }  

}
