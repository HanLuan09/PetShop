package controller.admin;

import java.io.IOException;
import java.util.List;

import dao.AccountDao;
import dao.UserProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.AccountProduct;
import model.Address;

@WebServlet(name = "AdminConfirmControl", urlPatterns = {"/confirm"})
public class AdminConfirmControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    	}
    	try {
    		String idO = request.getParameter("dio");
            AccountDao daoAccountDao = new AccountDao();
            daoAccountDao.setStauts(idO);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
        
        response.sendRedirect("admin");
        
    }

}