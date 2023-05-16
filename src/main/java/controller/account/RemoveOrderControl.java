package controller.account;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import dao.AccountDao;
import dao.RatingDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.AccountProduct;

@WebServlet(name = "RemoveOrderControl", urlPatterns = {"/remove-order"})
public class RemoveOrderControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    	}else {
    		String idO = request.getParameter("ido");
    		String idP = request.getParameter("idp");
    		
    		try {
    			AccountDao dAccountDao = new AccountDao();
    			dAccountDao.removeOrderDetails(idO, idP);
    		} catch (Exception e) {
    			request.getRequestDispatcher("error.jsp").forward(request, response);
    		}
    		response.sendRedirect("/petshop/order");
    	}
    	
    }
    
}
